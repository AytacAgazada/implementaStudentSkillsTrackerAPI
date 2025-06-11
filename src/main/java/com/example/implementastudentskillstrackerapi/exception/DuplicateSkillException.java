package com.example.implementastudentskillstrackerapi.exception;

public class DuplicateSkillException extends RuntimeException {
    public DuplicateSkillException(String skillName) {
        super("Skill already exists for this student: " + skillName);
    }
}