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
@Table(name = "professors")
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, length = 100)
    private String title;

//     ── Professor ↔ Subject = 1:N
//     INVERSE SIDE (not owning). The owning side is Subject.professor (@ManyToOne)
//     because the foreign key (professor_id) lives in the SUBJECT table.
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    private Set<SubjectEntity> subjects;


    // ── Professor ↔ Student = M:N
    // OWNING SIDE. We define the join table here.
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "Professor_student",
            joinColumns = @JoinColumn(name = "professor_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private  Set<StudentEntity> students;

}
