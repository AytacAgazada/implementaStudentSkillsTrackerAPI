package com.example.implementastudentskillstrackerapi.model.dto;

import com.example.implementastudentskillstrackerapi.model.enumeration.SkillLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillDataDto {

    private Long studentId;

    @NotBlank(message = "Skill name cannot be empty")
    private String skillName;

    @NotNull(message = "Skill level cannot be null")
    @Enumerated(EnumType.STRING)
    private SkillLevel level;


}
