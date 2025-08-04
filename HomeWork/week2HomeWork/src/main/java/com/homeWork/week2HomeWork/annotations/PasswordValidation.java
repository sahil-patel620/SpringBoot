package com.homeWork.week2HomeWork.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordValidation {
    String message() default "Password must contain at least one lowercase letter, one uppercase letter, one number, one special character, and be at least 10 characters long.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
