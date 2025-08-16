package com.week3.collegeManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String name;
    private List<String> professorNames;
    private List<String> subjectTitles;
    private Integer admissionFees;   // Directly from AdmissionRecord
}
