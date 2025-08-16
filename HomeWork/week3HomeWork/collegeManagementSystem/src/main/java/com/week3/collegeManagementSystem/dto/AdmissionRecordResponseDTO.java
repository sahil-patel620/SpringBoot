package com.week3.collegeManagementSystem.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecordResponseDTO {
    private Long id;
    private Integer fees;
    private String studentName;
}
