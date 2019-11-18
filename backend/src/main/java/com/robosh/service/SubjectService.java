package com.robosh.service;

import com.robosh.data.dto.SubjectDto;
import com.robosh.data.mapping.SubjectMapper;
import com.robosh.data.repository.SubjectRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;
    private SubjectMapper subjectMapper = SubjectMapper.INSTANCE;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public SubjectDto save(SubjectDto subjectDto) {
        return subjectMapper.subjectToDto(subjectRepository.save(subjectMapper.dtoToSubject(subjectDto)));
    }

    public SubjectDto findById(Long id) {
        return subjectMapper.subjectToDto(
                subjectRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Subject", "id", id)
                )
        );
    }

    public ResponseEntity delete(Long id) {
        subjectRepository.delete(subjectMapper.dtoToSubject(findById(id)));
        return ResponseEntity.ok().build();
    }

    public List<SubjectDto> findAll() {
        return subjectMapper.subjectsToDto(subjectRepository.findAll());
    }

    public List<SubjectDto> findSubjectsByGroupId(Long id) {
        return subjectMapper.subjectsToDto(subjectRepository.findSubjectsByGroupId(id));
    }

    public List<SubjectDto> findSubjectByTeacherId(Long id) {
        return subjectMapper.subjectsToDto(subjectRepository.findSubjectByTeacherId(id));
    }

    public List<SubjectDto> findSubjectByTeacherIdAndGroupId(Long teacherId, Long groupId) {
        return subjectMapper.subjectsToDto(subjectRepository.findSubjectByTeacherIdAndGroupId(teacherId, groupId));
    }

}
