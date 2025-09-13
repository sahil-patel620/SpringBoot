package com.sahil.SecurityApp.SecurityApplication.dto;

import com.sahil.SecurityApp.SecurityApplication.entity.enums.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDto {

    private String name;
    private String email;
    private String password;
    private Set<Role> roles;
}
