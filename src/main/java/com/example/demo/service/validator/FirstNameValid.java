package com.example.demo.service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FirstNameValid implements ConstraintValidator<FirstName, String> {
    @Override
    public boolean isValid(String firstName, ConstraintValidatorContext context) {
        return firstName.trim().length() >= 3;
    }
}
