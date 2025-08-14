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
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient =  patientRepository.findById(patientId).orElseThrow();

//      dirty patient
        patient.setInsurance(insurance); // patient knows about insurance, but insurance doesn't yet know about patient

        insurance.setPatient(patient); // optional, now insurance also knows about patient
        return insurance;
    }

    @Transactional
    public Insurance UpdateInsuranceOfAPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

//      dirty patient
        patient.setInsurance(insurance);

        insurance.setPatient(patient); // optional
        return insurance;
    }

    @Transactional
    public Patient removeInsuranceOfAPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

//      dirty patient
        patient.setInsurance(null);
        return patient;
    }
}
