package com.week3.HospitalManagementSystem;

import com.week3.HospitalManagementSystem.dto.BloodGroupStats;
import com.week3.HospitalManagementSystem.dto.CPatientInfo;
import com.week3.HospitalManagementSystem.dto.IPatientInfo;
import com.week3.HospitalManagementSystem.entities.Patient;
import com.week3.HospitalManagementSystem.repositories.PatientRepository;
import com.week3.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public  void testPatient(){
//        List<Patient> patientList = patientRepository.findAll();

//        List<IPatientInfo> patientList = patientRepository.getAllPatientsInfo();

//        List<CPatientInfo> patientList = patientRepository.getAllPatientsInfoConcrete();

//        List<BloodGroupStats> patientList = patientRepository.getBloodGroupStats();
//
//        for (BloodGroupStats p : patientList){
//            System.out.println(p);
//        }
//
//        int rowsAffected = patientRepository.updatePatientNameWithId("Sahil Patel", 1L);
//        System.out.println(rowsAffected);
//
////        understanding PersistenceContext and EntityManager
//        Patient patient = new Patient();
//        patientRepository.save(patient); // save is ultimately calling persist from entityManager

        patientService.testPatientTransaction();
    }
}
