package com.huiyun.student_service.service;

import com.huiyun.student_service.dto.StudentRequestDto;
import com.huiyun.student_service.entity.Student;
import com.huiyun.student_service.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(StudentRequestDto dto) {
        Student student = new Student();
        student.setStudentName(dto.getStudentName());
        student.setAddress(dto.getAddress());
        student.setMarks(dto.getMarks());
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
    }

    public Student updateStudent(StudentRequestDto dto, int studentId) {
        Student s = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));

        s.setStudentName(dto.getStudentName());
        s.setAddress(dto.getAddress());
        s.setMarks(dto.getMarks());

        return studentRepository.save(s);
    }

    public String deleteStudent(int studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new RuntimeException("Student not found with id: " + studentId);
        }
        studentRepository.deleteById(studentId);
        return "Student has been deleted";
    }

    public List<Student> searchStudentsByName(String name) {
        return studentRepository.findByStudentNameContaining(name);
    }
}