package com.springBootWebTutorial.springBootWebTutorialApplication.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PrimeNumberValidator implements ConstraintValidator<PrimeNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer num, ConstraintValidatorContext constraintValidatorContext) {
        if(num == null || num <= 1){
            return false;
        }
        for (int i = 2; i < num ; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
