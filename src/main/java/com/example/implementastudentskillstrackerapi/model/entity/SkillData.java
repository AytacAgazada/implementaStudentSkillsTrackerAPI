package com.example.implementastudentskillstrackerapi.model.entity;

import com.example.implementastudentskillstrackerapi.model.enumeration.SkillLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "skill_data")
@Data
public class SkillData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Student ID is required")
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @NotBlank(message = "Skill name cannot be blank")
    @Column(name = "skill_name", nullable = false)
    private String skillName;

    @NotNull(message = "Skill level is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false)
    private SkillLevel level;
}