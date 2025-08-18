package com.week3.collegeManagementSystem.repositories;

import com.week3.collegeManagementSystem.entities.AdmissionRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecordEntity, Long> {
}