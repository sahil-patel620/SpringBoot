package com.homeWork.week2HomeWork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homeWork.week2HomeWork.annotations.PasswordValidation;
import com.homeWork.week2HomeWork.annotations.PrimeNumberValidation;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long id;
    private  String title;
    @NotBlank
    private String userName;

    @PasswordValidation
    private String password;

    @JsonProperty("isActive")
    private Boolean isActive;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    @CreditCardNumber
    private String dummyCreditCard;

    @URL
    private String departmentWebsite;

    @PrimeNumberValidation
    private Integer isPrime;
}
