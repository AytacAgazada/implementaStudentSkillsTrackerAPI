package com.example.implementastudentskillstrackerapi.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentRequestDTO {

    @NotBlank
    @Size(min=2,max=30,message = "name length should be min 2 max 30")
    private String fullName;

    @Email(message = "email is not valid")
    @NotBlank(message = "email can't be blank")
    private String email;

    @Pattern(regexp = "^\\+994\\d{9}$", message = "Phone number must match +994XXXXXXXXX format")
    private String phoneNumber;

}
