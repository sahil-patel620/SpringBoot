package com.springBootWebTutorial.springBootWebTutorialApplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springBootWebTutorial.springBootWebTutorialApplication.annotations.EmployeeRoleValidation;
import com.springBootWebTutorial.springBootWebTutorialApplication.annotations.EvenNumberValidation;
import com.springBootWebTutorial.springBootWebTutorialApplication.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// this is our POJO class , this is used to define some entities inside our code.
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private  Long id;

    @NotBlank(message = "Name of Employee cannot be empty")
    @Size(min = 2, max = 10, message = "Number of character in name should be in range: [2, 10]")
    private  String name;

    @NotBlank(message = "Email of Employee cannot be empty")
    @Email(message = "Email should be a valid email")
    private String email;

    @Max(value = 80, message = "Age of Employee cannot be greater than 80")
    @Min(value = 18, message = "Age of Employee cannot be less than 80")
    private Integer age;

    @PastOrPresent(message = "dateOfJoining cannot be in future")
    private LocalDate dateOfJoining;

    @NotBlank(message = "Role of Employee cannot be empty")
//    @Pattern(regexp = "^(?i)(ADMIN|USER)$", message = "Role must be either ADMIN or USER")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of Employee should be not Null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 7, fraction = 2, message = "The salary can be in form of XXXXXXX.YY")
    @DecimalMax(value = "1000000.99")
    @DecimalMin(value = "10000.50")
    private Double salary;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @PrimeNumberValidation(message = "Number must be a prime number")
//    @EvenNumberValidation(message = "Number must be a even number")
    private  Integer primeNumber;


}
