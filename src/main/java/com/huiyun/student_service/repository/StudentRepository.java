package com.huiyun.student_service.repository;

import com.huiyun.student_service.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByStudentNameContaining(String name);
}
