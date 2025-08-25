package com.sahil.prod_ready_features.prod_ready_features.dtos;

import lombok.*;

import java.time.LocalDate;

// this is our POJO class , this is used to define some entities inside our code.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private LocalDate dateOfJoining;

    private String role;

    private Double salary;

    private Boolean isActive;

    private Integer primeNumber;

}
