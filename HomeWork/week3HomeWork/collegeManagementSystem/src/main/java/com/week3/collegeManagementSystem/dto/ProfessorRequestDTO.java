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
public class ProfessorRequestDTO {
    private  String title;
    private List<Long> subjectIds;
    private  List<Long> studentIds;
}
