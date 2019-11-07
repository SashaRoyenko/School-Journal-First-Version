package com.robosh.data.repository;

import com.robosh.data.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    List<Student> findStudentByGroupId(Long id);
}
