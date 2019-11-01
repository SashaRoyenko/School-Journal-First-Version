package com.robosh.service;

import com.robosh.data.dto.TeacherDto;
import com.robosh.data.mapping.TeacherMapper;
import com.robosh.data.repository.TeacherRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, BCryptPasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        teacherMapper = TeacherMapper.INSTANCE;
    }

    public TeacherDto save(TeacherDto teacherDto) {
        teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
        return teacherMapper.teacherToDto(teacherRepository.save(teacherMapper.dtoToTeacher(teacherDto)));
    }

    public List<TeacherDto> findAll(){
        return teacherMapper.teachersToDto(teacherRepository.findAll());
    }

    public TeacherDto findById(Long id) {
        return teacherMapper.teacherToDto(teacherRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Teacher", "id", id)
        ));
    }

    public ResponseEntity<?> delete(Long id){
        teacherRepository.delete(teacherMapper.dtoToTeacher(findById(id)));
        return ResponseEntity.ok().build();
    }

    public List<TeacherDto> findTeachersByGroupId(Long id){
        return teacherMapper.teachersToDto(teacherRepository.findTeachersByGroupId(id));
    }
}
