package com.robosh.service;

import com.robosh.data.dto.ParentDto;
import com.robosh.data.mapping.ParentMapper;
import com.robosh.data.mapping.TeacherMapper;
import com.robosh.data.repository.ParentRepository;
import com.robosh.data.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    private ParentRepository parentRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private ParentMapper parentMapper;

    @Autowired
    public ParentService(ParentRepository parentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.parentRepository = parentRepository;
        this.passwordEncoder = passwordEncoder;
        parentMapper = ParentMapper.INSTANCE;
    }

    public ParentDto save(ParentDto parentDto) {
        parentDto.setPassword(passwordEncoder.encode(parentDto.getPassword()));
        return parentMapper.parentToDto(parentRepository.save(parentMapper.dtoToParent(parentDto)));
    }

//    teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
//        return teacherMapper.teacherToDto(teacherRepository.save(teacherMapper.dtoToTeacher(teacherDto)));
}
