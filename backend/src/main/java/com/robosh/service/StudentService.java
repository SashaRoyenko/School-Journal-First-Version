package com.robosh.service;

import com.robosh.data.dto.StudentDto;
import com.robosh.data.entity.Student;
import com.robosh.data.mapping.StudentMapper;
import com.robosh.data.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        studentMapper = StudentMapper.INSTANCE;
    }

//    public List<StudentDto> findStudentByGroupId(Long id){
////        return studentMapper.studentsToDto(studentRepository.findStudentByGroupId(id));
//    }

}
