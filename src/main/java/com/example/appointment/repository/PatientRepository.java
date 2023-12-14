package com.example.appointment.repository;

import com.example.appointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientBy(Long id);
}
