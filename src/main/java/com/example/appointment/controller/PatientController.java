package com.example.appointment.controller;

import com.example.appointment.model.Patient;
import com.example.appointment.repository.PatientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Patient", description = "Manages Patients operations")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Create a new patient
    @Operation(summary = "Create a new Patient")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {
                    @Content(schema = @Schema(implementation = Patient.class), mediaType = "application/json"),
            }, description = "Creation OK"),
    })
    @PostMapping("/patient")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        Patient savePatient = patientRepository.save(patient);
        return ResponseEntity
                .ok(savePatient);
    }
}
