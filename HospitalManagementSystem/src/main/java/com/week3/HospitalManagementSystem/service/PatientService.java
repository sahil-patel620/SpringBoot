package com.week3.HospitalManagementSystem.service;

import com.week3.HospitalManagementSystem.entities.Patient;
import com.week3.HospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){

        Patient p1 = patientRepository.findById(1L).orElseThrow();
        Patient p2 = patientRepository.findById(1L).orElseThrow();

        System.out.println(p1 + " " + p2);
        System.out.println(p1 == p2);

//      Entity is modified (got dirty), so Hibernate will detect the change via dirty checking
//      and synchronize it with the database when the transaction commits (or on flush).
        p1.setName("Random Name");

    }
}
