package com.example.appointment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "patient_id")
    private Patient patient;
    @Column(name = "appointment_date", nullable = false)
    @NotNull(message = "Appointment date is required")
    @DateTimeFormat(pattern = "dd-MM-yy")
    private LocalDate appointmentDate;
    @Column(name = "appointment_time", nullable = false)
    @NotNull(message = "Appointment time is required")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime appointmentTime;

    public Appointment() {
    }

    public Appointment(Long id, Patient patient, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.id = id;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @JsonProperty("patient_id")
    public Long getPatientId() {
        return (patient != null) ? patient.getId() : null;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
