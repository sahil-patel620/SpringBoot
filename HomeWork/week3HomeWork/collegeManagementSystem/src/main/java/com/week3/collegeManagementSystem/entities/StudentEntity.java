package com.week3.collegeManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, length = 50)
    private String name;

    // ── Professor ↔ Student = M:N
    // INVERSE SIDE. The owning side is Professor.students.
    @ManyToMany(mappedBy = "students", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.DETACH})
    private Set<ProfessorEntity> professors;

    // ── Student ↔ Subject = M:N
    // INVERSE SIDE.
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "students",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<SubjectEntity> subjects;

    // ── Student ↔ AdmissionRecord = 1:1
    // INVERSE SIDE. The owning side is AdmissionRecord.student,
    // because the FK (student_id) is in ADMISSION_RECORD table.
    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private AdmissionRecordEntity admissionRecord;

}
