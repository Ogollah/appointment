package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.model.Patient;
import com.example.appointment.repository.AppointmentRepository;
import com.example.appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientService patientService;

    @PostMapping("/appointment/{id}")
    public ResponseEntity<Appointment> savePatient(@RequestBody Appointment appointment, @PathVariable("id") Long id){
        Patient patient = patientService.getPatientById(id);
        Appointment appointmentPatient = new Appointment();
        appointmentPatient.setPatient(patient);
        Appointment saveAppointment = appointmentRepository.save(appointment);
        return ResponseEntity
                .created(URI
                        .create(String.format("/Appointment/%s", appointment.getAppointmentDate())))
                .body(saveAppointment);
    }
}
