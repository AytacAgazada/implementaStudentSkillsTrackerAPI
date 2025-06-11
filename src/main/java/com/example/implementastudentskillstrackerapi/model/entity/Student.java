package com.example.implementastudentskillstrackerapi.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name cannot be blank")
    @Size(min = 3, message = "Full name must be at least 3 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Full name can only contain letters and spaces")
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cannot be blank")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // Harmonized with DTO's phone number validation for consistency
    @Pattern(regexp = "^\\+994\\d{9}$", message = "Phone number must match +994XXXXXXXXX format")
    @NotBlank(message = "Phone number cannot be blank") // Ensure phone number is not blank in entity
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}