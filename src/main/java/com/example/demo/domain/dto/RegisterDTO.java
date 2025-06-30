package com.example.demo.domain.dto;
import com.example.demo.service.validator.FirstName;
import com.example.demo.service.validator.LastName;
import com.example.demo.service.validator.RegisterChecked;
import jakarta.validation.constraints.NotBlank;

@RegisterChecked
public class RegisterDTO {
    @FirstName
    @NotBlank(message = "Tên là bắt buộc")
    private String firstName;
    @LastName
    @NotBlank(message = "Tên là bắt buộc")
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
