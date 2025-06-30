package com.example.demo.service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = FirstNameValid.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FirstName {
    String message() default "First Name must be at least 2 characters long";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
