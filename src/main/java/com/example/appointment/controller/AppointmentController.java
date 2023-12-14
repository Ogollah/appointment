package com.example.appointment.controller;

import com.example.appointment.model.Appointment;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> savePatient(@RequestBody Appointment appointment){
        Appointment saveAppointment = appointmentRepository.save(appointment);
        return ResponseEntity
                .created(URI
                        .create(String.format("/Appointment/%s", appointment.getAppointmentDate())))
                .body(saveAppointment);
    }
}
