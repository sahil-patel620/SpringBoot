package com.week3.collegeManagementSystem.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String title;

    @JsonIgnore
    private Set<SubjectDTO> subjects;

    private Set<StudentDTO> students;
}
