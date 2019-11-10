package com.robosh.service;

import com.robosh.data.dto.ParentDto;
import com.robosh.data.entity.Parent;
import com.robosh.data.mapping.ParentMapper;
import com.robosh.data.repository.ParentRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ParentDto findByParentId(Long id) {
        return parentMapper.parentToDto(findById(id));
    }

    public Parent findById(Long id) {
        return parentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Parent", "id", id)
        );
    }

    public ResponseEntity<?> delete(Long id) {
        parentRepository.delete(findById(id));
        return ResponseEntity.ok().build();
    }

    public List<ParentDto> findAll() {
        return parentMapper.parentsToDto(parentRepository.findAll());
    }
}
