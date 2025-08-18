package com.week3.collegeManagementSystem.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.week3.collegeManagementSystem.entities.ProfessorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;

    @JsonIgnore
    private Set<ProfessorDTO> professors;
    @JsonIgnore
    private Set<SubjectDTO> subjects;
    @JsonIgnore
    private AdmissionRecordDTO admissionRecord;
}
