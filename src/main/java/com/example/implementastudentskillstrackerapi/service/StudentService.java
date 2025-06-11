package com.example.implementastudentskillstrackerapi.service;

import com.example.implementastudentskillstrackerapi.exception.StudentNotFoundException;
import com.example.implementastudentskillstrackerapi.model.dto.StudentDto;
import com.example.implementastudentskillstrackerapi.model.entity.Student;
import com.example.implementastudentskillstrackerapi.repository.SkillDataRepository;
import com.example.implementastudentskillstrackerapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Import for @Transactional

import java.util.List;

@Service
@RequiredArgsConstructor // Lombok will generate the constructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final SkillDataRepository skillDataRepository;

    // Manual constructor removed, @RequiredArgsConstructor handles it

    @Transactional // Ensure email uniqueness is handled atomically
    public Student createStudent(StudentDto studentDto) {
        if (studentRepository.existsByEmail(studentDto.getEmail())) {
            throw new IllegalArgumentException("Student with this email already exists: " + studentDto.getEmail());
        }

        Student student = new Student();
        student.setFullName(studentDto.getFullName());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNumber(studentDto.getPhoneNumber());

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Transactional // Ensure both student and skills are deleted atomically
    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }
        skillDataRepository.deleteByStudentId(id); // Delete associated skills first
        studentRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }
}