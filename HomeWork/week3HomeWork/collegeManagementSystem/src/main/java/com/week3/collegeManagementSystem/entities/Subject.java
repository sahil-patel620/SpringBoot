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
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    // ── Professor ↔ Subject = 1:N
    // OWNING SIDE. This side holds the FK column professor_id.
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;


    // ── Student ↔ Subject = M:N
    // INVERSE SIDE. The owning side is Student.subjects
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students = new ArrayList<>();

}
