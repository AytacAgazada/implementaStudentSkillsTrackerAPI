package com.example.implementastudentskillstrackerapi.service;

import com.example.implementastudentskillstrackerapi.model.dto.StudentDto;
import com.example.implementastudentskillstrackerapi.model.entity.SkillData;
import com.example.implementastudentskillstrackerapi.repository.SkillDataRepository;

public class SkillDataService {
    private final SkillDataRepository skillDataRepository;

    public SkillDataService(SkillDataRepository skillDataRepository) {
        this.skillDataRepository = skillDataRepository;
    }

    public SkillData create(StudentDto studentDto) {
        SkillData skillData = new SkillData();
        skillData.setSkillLevel(skillData.getSkillLevel());
        skillData.setSkillName(skillData.getSkillName());

    }
}
