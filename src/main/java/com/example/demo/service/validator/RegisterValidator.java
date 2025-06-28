package com.example.demo.service.validator;

import com.example.demo.domain.dto.RegisterDTO;
import com.example.demo.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class RegisterValidator implements ConstraintValidator<RegisterChecked, RegisterDTO> {
    private UserService userService;
    public RegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(RegisterDTO user, ConstraintValidatorContext context) {
        boolean valid = true;

        // Check if password fields match
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            context.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }
      if(this.userService.checkIfEmailExists(user.getEmail())) {
          context.buildConstraintViolationWithTemplate("Email already exists")
                  .addPropertyNode("email")
                  .addConstraintViolation()
                  .disableDefaultConstraintViolation();
          valid = false;
      }
        // Additional validations can be added here

        return valid;
    }
}
