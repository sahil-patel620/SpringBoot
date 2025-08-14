package com.week3.HospitalManagementSystem.repositories;

import com.week3.HospitalManagementSystem.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}