package com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement;

import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.entity.Appointment;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.repository.AppointmentRepository;
import com.arathin.hospitalmanagementapp.nagendrappa_aarathi_hospitalmanagement.service.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveAppointment() {
        Appointment appointment = new Appointment();
        appointment.setId(1L);
        appointment.setDoctorName("Dr. Smith");
        appointment.setPatientName("John Doe");
        appointment.setAppointmentDate(LocalDate.of(2024, 7, 23));

        appointmentService.saveAppointment(appointment);

        verify(appointmentRepository, times(1)).save(any(Appointment.class));
    }

    @Test
    void testFindAllAppointments() {
        Appointment appointment1 = new Appointment();
        appointment1.setId(1L);
        appointment1.setDoctorName("Dr. Smith");
        appointment1.setPatientName("John Doe");
        appointment1.setAppointmentDate(LocalDate.of(2024, 7, 23));

        Appointment appointment2 = new Appointment();
        appointment2.setId(2L);
        appointment2.setDoctorName("Dr. Brown");
        appointment2.setPatientName("Jane Doe");
        appointment2.setAppointmentDate(LocalDate.of(2024, 7, 24));

        List<Appointment> appointments = Arrays.asList(appointment1, appointment2);

        when(appointmentRepository.findAll()).thenReturn(appointments);

        List<Appointment> result = (List<Appointment>) appointmentService.findAllAppointments();

        assertEquals(2, result.size());
        assertEquals("Dr. Smith", result.get(0).getDoctorName());
        assertEquals("Dr. Brown", result.get(1).getDoctorName());
    }
}
