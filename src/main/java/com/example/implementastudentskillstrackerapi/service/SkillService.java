package com.example.implementastudentskillstrackerapi.service;

import com.example.implementastudentskillstrackerapi.exception.DuplicateSkillException;
import com.example.implementastudentskillstrackerapi.exception.StudentNotFoundException;
import com.example.implementastudentskillstrackerapi.model.dto.SkillDto;
import com.example.implementastudentskillstrackerapi.model.entity.SkillData;
import com.example.implementastudentskillstrackerapi.repository.SkillDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor // Lombok will generate the constructor
public class SkillService {

    private final SkillDataRepository skillDataRepository;
    private final StudentService studentService;


    public SkillData addSkillToStudent(Long studentId, SkillDto skillDto) {
        if (!studentService.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }

        if (skillDataRepository.existsByStudentIdAndSkillNameIgnoreCase(studentId, skillDto.getSkillName())) {
            throw new DuplicateSkillException(skillDto.getSkillName());
        }

        SkillData skillData = new SkillData();
        skillData.setStudentId(studentId);
        skillData.setSkillName(skillDto.getSkillName());
        skillData.setLevel(skillDto.getLevel());

        return skillDataRepository.save(skillData);
    }

    public List<SkillData> getSkillsForStudent(Long studentId) {
        if (!studentService.existsById(studentId)) {
            throw new StudentNotFoundException(studentId);
        }

        return skillDataRepository.findByStudentId(studentId);
    }

    public Map<String, Long> getSkillStatistics() {
        List<Object[]> results = skillDataRepository.getSkillStatistics();
        Map<String, Long> statistics = new HashMap<>();

        for (Object[] result : results) {
            String skillName = (String) result[0];
            Long count = (Long) result[1];
            statistics.put(skillName, count);
        }

        return statistics;
    }
}