package com.week3.HospitalManagementSystem.repositories;

import com.week3.HospitalManagementSystem.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}