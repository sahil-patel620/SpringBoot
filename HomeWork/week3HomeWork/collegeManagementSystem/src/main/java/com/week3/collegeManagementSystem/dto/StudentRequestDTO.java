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
public class StudentRequestDTO {

    private String name;
    private List<Long> professorIds;     // For M:N mapping
    private List<Long> subjectIds;       // For M:N mapping
    private Long admissionRecordId;      // Optional for linking
}
