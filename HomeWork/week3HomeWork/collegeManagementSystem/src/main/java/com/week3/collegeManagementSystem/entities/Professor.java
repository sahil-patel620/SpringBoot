package com.week3.collegeManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

//     ── Professor ↔ Subject = 1:N
//     INVERSE SIDE (not owning). The owning side is Subject.professor (@ManyToOne)
//     because the foreign key (professor_id) lives in the SUBJECT table.
    @OneToMany(mappedBy = "professor")
    private List<Subject> subjects = new ArrayList<>();


    // ── Professor ↔ Student = M:N
    // OWNING SIDE. We define the join table here.
    @ManyToMany()
//    @JoinColumn(name = "student_List")
    private  List<Student> students = new ArrayList<>();

}
