package com.robosh.service;

import com.robosh.data.dto.ParentDto;
import com.robosh.data.mapping.TeacherMapper;
import com.robosh.data.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    private Parent repository;
    private TeacherMapper mapper;

    public void save(ParentDto parentDto) {
    }
}
