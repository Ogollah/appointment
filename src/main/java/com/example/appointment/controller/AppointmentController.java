package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.model.Patient;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.service.AppointmentService;
import com.example.appointment.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Appointment", description = "Manages Patients appointments")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientService patientService;

    // Create a new appointment
    @Operation(summary = "Create a new appointment")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = Appointment.class), mediaType = "application/json"),
            }, description = "Creation OK"),
    })
    @PostMapping("/appointments/{patientId}/schedule")
    public ResponseEntity<Appointment> savePatient(@RequestBody Appointment appointment, @PathVariable("patientId") Long patientId){
        try {
            if (appointment.getAppointmentDate() == null || appointment.getAppointmentTime() == null) {
                return ResponseEntity.badRequest().build();
            }
            Appointment saveAppointment = appointmentService.scheduleAppointment(
                    patientId,
                    appointment.getAppointmentDate(),
                    appointment.getAppointmentTime()
            );
            return ResponseEntity
                    .ok(saveAppointment);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
