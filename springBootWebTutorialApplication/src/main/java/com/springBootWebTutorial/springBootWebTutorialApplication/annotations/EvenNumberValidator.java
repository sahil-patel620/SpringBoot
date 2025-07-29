package com.springBootWebTutorial.springBootWebTutorialApplication.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EvenNumberValidator implements ConstraintValidator<EvenNumberValidation, Integer> {
    @Override
    public boolean isValid(Integer number, ConstraintValidatorContext constraintValidatorContext) {
        return number % 2 == 0;
    }
}
