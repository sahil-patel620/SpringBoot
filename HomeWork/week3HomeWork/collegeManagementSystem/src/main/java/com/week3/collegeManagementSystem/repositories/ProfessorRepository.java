package com.week3.collegeManagementSystem.repositories;

import com.week3.collegeManagementSystem.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}