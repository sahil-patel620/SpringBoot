package com.week3.collegeManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    // ── Professor ↔ Student = M:N
    // INVERSE SIDE. The owning side is Professor.students.
    @ManyToMany(mappedBy = "students")
    private List<Professor> professors = new ArrayList<>();

    // ── Student ↔ Subject = M:N
    // OWNING SIDE. We define the join table here.
    @ManyToMany()
//    @JoinColumn(name = "subject_List")
    private List<Subject> subjects = new ArrayList<>();

    // ── Student ↔ AdmissionRecord = 1:1
    // INVERSE SIDE. The owning side is AdmissionRecord.student,
    // because the FK (student_id) is in ADMISSION_RECORD table.
    @OneToOne(mappedBy = "student")
    private AdmissionRecord admissionRecord;

}
