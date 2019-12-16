package com.robosh.service;

import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Teacher;
import com.robosh.data.entity.User;
import com.robosh.data.mapping.TeacherMapper;
import com.robosh.data.repository.TeacherRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, BCryptPasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        teacherMapper = TeacherMapper.INSTANCE;
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public TeacherDto save(TeacherDto teacherDto) {
        teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
        return teacherMapper.teacherToDto(teacherRepository.save(teacherMapper.dtoToTeacher(teacherDto)));
    }

    public List<TeacherDto> findAll() {
        return teacherMapper.teachersToDto(teacherRepository.findAll());
    }

    public TeacherDto findById(Long id) {
        return teacherMapper.teacherToDto(teacherRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Teacher", "id", id)
        ));
    }

    public ResponseEntity delete(Long id) {
        teacherRepository.delete(teacherMapper.dtoToTeacher(findById(id)));
        return ResponseEntity.ok().build();
    }

    public List<TeacherDto> findTeacherByGroupId(Long id) {
        return teacherMapper.teachersToDto(teacherRepository.findTeacherByGroupId(id));
    }

    public TeacherDto update(TeacherDto teacherDto) {
        if (teacherDto.getPassword() != null) {
            teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
        }
        Teacher currentUser = teacherMapper.dtoToTeacher(findById(teacherDto.getId()));
        User updateUser = teacherMapper.dtoToTeacher(teacherDto);
        modelMapper.map(updateUser, currentUser);
        return teacherMapper.teacherToDto(teacherRepository.save(currentUser));
    }

}
