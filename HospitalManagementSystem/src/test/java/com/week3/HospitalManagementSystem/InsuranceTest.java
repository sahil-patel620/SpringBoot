package com.week3.HospitalManagementSystem;

import com.week3.HospitalManagementSystem.entities.Appointment;
import com.week3.HospitalManagementSystem.entities.Insurance;
import com.week3.HospitalManagementSystem.service.AppointmentService;
import com.week3.HospitalManagementSystem.service.InsuranceService;
import com.week3.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Test
    public  void testAssignInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance,1L);

        System.out.println(updatedInsurance);

        patientService.deletePatientById(1L);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .reason("Fever")
                .appointmentTime(LocalDateTime.of(2025,11,12,14,0,0))
                .build();

        var updatedAppointment = appointmentService.createANewAppointment(appointment,1L, 2L);
        System.out.println(updatedAppointmen t);

        patientService.deletePatientById(1L);

    }
}
