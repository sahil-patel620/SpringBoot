package com.homeWork.week2HomeWork.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation,Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        if(number == null || number <= 1 ) return false;
        for (int i = 2; i < number ; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
