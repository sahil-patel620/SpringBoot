package com.week3.collegeManagementSystem.repositories;

import com.week3.collegeManagementSystem.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}