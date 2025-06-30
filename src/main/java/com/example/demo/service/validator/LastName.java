package com.example.demo.service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = LastNameValid.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LastName {
    String message() default "Last Name must be at least 2 characters long";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
