package com.robosh.service;

import com.robosh.data.dto.ParentDto;
import com.robosh.data.entity.Parent;
import com.robosh.data.entity.User;
import com.robosh.data.mapping.ParentMapper;
import com.robosh.data.repository.ParentRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    public ParentService(ParentRepository parentRepository, BCryptPasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.parentRepository = parentRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
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

    public ResponseEntity delete(Long id) {
        parentRepository.delete(findById(id));
        return ResponseEntity.ok().build();
    }

    public List<ParentDto> findAll() {
        return parentMapper.parentsToDto(parentRepository.findAll());
    }

    public ParentDto update(ParentDto parentDto) {
        if (parentDto.getPassword() != null) {
            parentDto.setPassword(passwordEncoder.encode(parentDto.getPassword()));
        }
        Parent currentUser = findById(parentDto.getId());
        User updateUser = parentMapper.dtoToParent(parentDto);
        modelMapper.map(updateUser, currentUser);
        return parentMapper.parentToDto(parentRepository.save(currentUser));
    }
}
