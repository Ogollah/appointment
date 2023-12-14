package com.example.appointment.service;

import com.example.appointment.model.Patient;
import com.example.appointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Patient getPatientById(Long id)
    {
        return patientRepository.findPatientBy(id);
    }
}
