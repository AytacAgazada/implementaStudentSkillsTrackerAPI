package com.example.implementastudentskillstrackerapi.repository;

import com.example.implementastudentskillstrackerapi.model.entity.SkillData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SkillDataRepository extends JpaRepository<SkillData, Long> {

    List<SkillData> findByStudentId(Long studentId);

    boolean existsByStudentIdAndSkillNameIgnoreCase(Long studentId, String skillName);

    @Modifying
    @Transactional
    void deleteByStudentId(Long studentId); // Added for cascading delete

    @Query("SELECT s.skillName, COUNT(DISTINCT s.studentId) FROM SkillData s GROUP BY s.skillName")
    List<Object[]> getSkillStatistics();
}