package com.week3.HospitalManagementSystem.service;

import com.week3.HospitalManagementSystem.entities.Insurance;
import com.week3.HospitalManagementSystem.entities.Patient;
import com.week3.HospitalManagementSystem.repositories.InsuranceRepository;
import com.week3.HospitalManagementSystem.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    @Transactional
    public void assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient =  patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);

    }
}
