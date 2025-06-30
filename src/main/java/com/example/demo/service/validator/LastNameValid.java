package com.example.demo.service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class LastNameValid implements ConstraintValidator<LastName, String> {
    @Override
    public boolean isValid(String lastName, ConstraintValidatorContext context) {
        return lastName.trim().length() > 3;
    }
}
