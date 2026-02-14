package com.huiyun.student_service.controller;

import com.huiyun.student_service.dto.StudentRequestDto;
import com.huiyun.student_service.entity.Student;
import com.huiyun.student_service.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // POST: Create a new student
    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentRequestDto dto) {
        // Manual validation
        if (dto.getStudentName() == null || dto.getStudentName().isEmpty()) {
            return ResponseEntity.badRequest().body("Student name is required");
        }
        if (dto.getAddress() == null || dto.getAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("Address is required");
        }
        if (dto.getMarks() == null || dto.getMarks().isEmpty()) {
            return ResponseEntity.badRequest().body("Marks are required");
        }

        Student student = studentService.createStudent(dto);
        return ResponseEntity.status(201).body("Student created successfully");
    }

    // GET: Retrieve all students
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET: Retrieve a student by ID
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }

    // PUT: Update a student
    @PutMapping("/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
                                                @RequestBody StudentRequestDto dto) {
        // Manual validation
        if (dto.getStudentName() == null || dto.getStudentName().isEmpty()) {
            return ResponseEntity.badRequest().body("Student name is required");
        }
        if (dto.getAddress() == null || dto.getAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("Address is required");
        }
        if (dto.getMarks() == null || dto.getMarks().isEmpty()) {
            return ResponseEntity.badRequest().body("Marks are required");
        }

        Student updatedStudent = studentService.updateStudent(dto, studentId);
        return ResponseEntity.ok("Student updated successfully");
    }

    // DELETE: Delete a student by ID
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student has been deleted");
    }

    // GET: Search for students by name (RequestParam)
    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam("name") String name) {
        List<Student> students = studentService.searchStudentsByName(name);
        return ResponseEntity.ok(students);
    }
}