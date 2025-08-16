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
public class ProfessorResponseDTO {
    private Long id;
    private  String title;
    private List<String> subjectTitles;
    private  List<String> studentNames;
}
