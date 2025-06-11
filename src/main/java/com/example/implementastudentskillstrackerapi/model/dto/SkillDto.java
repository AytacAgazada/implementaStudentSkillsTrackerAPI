package com.example.implementastudentskillstrackerapi.model.dto;

import com.example.implementastudentskillstrackerapi.model.enumeration.SkillLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillDto {

    @NotBlank(message = "Skill name cannot be blank")
    private String skillName;

    @NotNull(message = "Skill level is required")
    private SkillLevel level;
}