package com.example.implementastudentskillstrackerapi.controller;

import com.example.implementastudentskillstrackerapi.model.dto.SkillDto;
import com.example.implementastudentskillstrackerapi.model.entity.SkillData;
import com.example.implementastudentskillstrackerapi.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @PostMapping("/{id}/skills")
    public ResponseEntity<SkillData> addSkillToStudent(
            @PathVariable("id") Long studentId, // Renamed for clarity
            @Valid @RequestBody SkillDto skillDto) {
        SkillData createdSkill = skillService.addSkillToStudent(studentId, skillDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSkill);
    }

    @GetMapping("/{id}/skills")
    public ResponseEntity<List<SkillData>> getSkillsForStudent(@PathVariable("id") Long studentId) { // Renamed for clarity
        List<SkillData> skills = skillService.getSkillsForStudent(studentId);
        return ResponseEntity.ok(skills);
    }

    @GetMapping("/skills/statistics")
    public ResponseEntity<Map<String, Long>> getSkillStatistics() {
        Map<String, Long> statistics = skillService.getSkillStatistics();
        return ResponseEntity.ok(statistics);
    }
}