package com.week3.HospitalManagementSystem.repositories;

import com.week3.HospitalManagementSystem.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}