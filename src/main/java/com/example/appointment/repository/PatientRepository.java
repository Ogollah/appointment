package com.example.appointment.repository;

import com.example.appointment.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findPatientById(Long id);
}
