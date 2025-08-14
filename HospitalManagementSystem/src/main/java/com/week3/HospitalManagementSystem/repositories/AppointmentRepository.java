package com.week3.HospitalManagementSystem.repositories;

import com.week3.HospitalManagementSystem.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}