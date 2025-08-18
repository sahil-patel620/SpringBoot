package com.week3.collegeManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admissions")
public class AdmissionRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer fees;

    // ── Student ↔ AdmissionRecord = 1:1
    // OWNING SIDE. FK student_id lives here.
    @OneToOne(fetch = FetchType.LAZY)
    private StudentEntity student;

}
