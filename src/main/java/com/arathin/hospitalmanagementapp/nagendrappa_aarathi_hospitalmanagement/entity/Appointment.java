package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for the appointment

    private String doctorName;  // Name of the doctor for the appointment
    private String patientName; // Name of the patient for the appointment
    private LocalDate appointmentDate; // Date of the appointment

    // Getter for the appointment ID
    public Long getId() {
        return id;
    }

    // Setter for the appointment ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for the doctor's name
    public String getDoctorName() {
        return doctorName;
    }

    // Setter for the doctor's name
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getter for the patient's name
    public String getPatientName() {
        return patientName;
    }

    // Setter for the patient's name
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // Getter for the appointment date
    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    // Setter for the appointment date
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
