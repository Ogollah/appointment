package com.example.appointment.service;

import com.example.appointment.model.Appointment;
import com.example.appointment.model.Patient;
import com.example.appointment.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientService patientService;

    public Appointment scheduleAppointment(Long patientId, LocalDate appointmentDate, LocalTime appointmentTime) {

        Appointment appointment = new Appointment();
        appointment.setPatient(patientService.getPatientById(patientId));
        appointment.setAppointmentDate(appointmentDate);
        appointment.setAppointmentTime(appointmentTime);
        return appointmentRepository.save(appointment);
    }
}
