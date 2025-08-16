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
public class SubjectRequestDTO {
    private  String title;    // Matches entity name
    private  Long professorId;  // Subject has ONE professor
    private List<Long> studentIds; // Students taking this subject
}
