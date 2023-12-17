package com.example.appointment.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    private String surname;
    @Column(name = "other_name")
    private String otherName;
    @Column(name = "patient_number")
    private String patientNumber;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "mobile_number")
    private String mobileNumber;
    private String email;
    @Column(name = "alt_contact_person")
    private String altContactPerson;
    @Column(name = "alt_contact_person_phone")
    private String altContactPersonPhone;
    private boolean disability;
    private String county;

    public Patient() {
    }

    public Patient(Long id, String firstName, String surname, String otherName, String patientNumber, LocalDate birthDate,
                   String idNumber, String mobileNumber, String email, String altContactPerson, boolean disability, String county) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.otherName = otherName;
        this.patientNumber = patientNumber;
        this.birthDate = birthDate;
        this.idNumber = idNumber;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.altContactPerson = altContactPerson;
        this.disability = disability;
        this.county = county;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAltContactPerson() {
        return altContactPerson;
    }

    public void setAltContactPerson(String altContactPerson) {
        this.altContactPerson = altContactPerson;
    }

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public String getAltContactPersonPhone() {
        return altContactPersonPhone;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setAltContactPersonPhone(String altContactPersonPhone) {
        this.altContactPersonPhone = altContactPersonPhone;


    }
}
