package com.example.implementastudentskillstrackerapi.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentDto {

    @NotBlank(message = "Full name cannot be blank")
    @Size(min=2, max=30, message = "Name length should be min 2 max 30")
    private String fullName;

    @Email(message = "Email is not valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Pattern(regexp = "^\\+994\\d{9}$", message = "Phone number must match +994XXXXXXXXX format")
    @NotBlank(message = "Phone number cannot be blank") // Added @NotBlank for phone number
    private String phoneNumber;
}