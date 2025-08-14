package com.week3.HospitalManagementSystem.service;

import com.week3.HospitalManagementSystem.entities.Appointment;
import com.week3.HospitalManagementSystem.entities.Doctor;
import com.week3.HospitalManagementSystem.entities.Patient;
import com.week3.HospitalManagementSystem.repositories.AppointmentRepository;
import com.week3.HospitalManagementSystem.repositories.DoctorRepository;
import com.week3.HospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private  final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }
}
