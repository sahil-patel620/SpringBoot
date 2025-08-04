package com.homeWork.week2HomeWork.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.homeWork.week2HomeWork.annotations.PasswordValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String title;
    private String userName;
    private String password;

    @JsonProperty("isActive")
    private Boolean isActive;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    private Integer isPrime;

    private String dummyCreditCard;

    @URL
    private String departmentWebsite;
}
