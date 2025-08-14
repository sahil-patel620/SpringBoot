package com.week3.HospitalManagementSystem.repositories;

import com.week3.HospitalManagementSystem.dto.BloodGroupStats;
import com.week3.HospitalManagementSystem.dto.CPatientInfo;
import com.week3.HospitalManagementSystem.dto.IPatientInfo;
import com.week3.HospitalManagementSystem.entities.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
//        List<Patient> findByEmailContaining(String id);

//      We are using interface (instead of concrete DTO) ,so Hibernate is creating proxy object to get data
//      It is only for read-only data it can't modify data
        @Query("select p.id as id, p.name as name, p.email as email from Patient p")
        List<IPatientInfo> getAllPatientsInfo();

//      We can modify in this because we are using concrete DTO class here
        @Query("select new com.week3.HospitalManagementSystem.dto.CPatientInfo (p.id, p.name) from Patient p")
        List<CPatientInfo> getAllPatientsInfoConcrete();

//      This is query for aggregate function like count()
        @Query("select new com.week3.HospitalManagementSystem.dto.BloodGroupStats (p.bloodGroup, Count(p)) from Patient p group by p.bloodGroup order by Count(p) DESC")
        List<BloodGroupStats> getBloodGroupStats();

//      Update Query
        @Transactional
        @Modifying
        @Query("UPDATE Patient p set p.name=:name where p.id=:id")
        int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);

//      N+1 Query Optimization
        @Query("select p from Patient p LEFT JOIN FETCH p.appointments")
        List<Patient> getAllPatientsWithAppointment();
}
