package com.week3.collegeManagementSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
    private Long id;
    private String title;

    private ProfessorDTO professor;

    private Set<StudentDTO> students;
}
