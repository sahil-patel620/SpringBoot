package com.week3.collegeManagementSystem.dtos;

import com.week3.collegeManagementSystem.entities.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRecordDTO {
    private Long id;
//    @NotNull(message = "Fees should not be null")
    private Integer fees;
    private StudentDTO student;
}
