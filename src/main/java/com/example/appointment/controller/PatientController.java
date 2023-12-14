package com.example.appointment.controller;

import com.example.appointment.model.Patient;
import com.example.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/patient")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        Patient savePatient = patientRepository.save(patient);
        return ResponseEntity
                .created(URI
                        .create(String.format("/patients/%s", patient.getFirstName())))
                .body(savePatient);
    }
}
