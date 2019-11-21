package com.robosh.service;

import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.mapping.HomeworkMapper;
import com.robosh.data.repository.HomeworkRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkService {

    private HomeworkRepository homeworkRepository;
    private HomeworkMapper homeworkMapper;

    @Autowired
    public HomeworkService(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
        homeworkMapper = HomeworkMapper.INSTANCE;
    }

    public HomeworkDto save(HomeworkDto homeworkDto){
        return homeworkMapper.homeworkToDto(homeworkRepository.save(homeworkMapper.dtoToHomework(homeworkDto)));
    }

    public HomeworkDto findById(Long id){
        return homeworkMapper.homeworkToDto(
                homeworkRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Homework", "id", id)
                )
        );
    }

    public List<HomeworkDto> findByGroupId(Long id){
        return homeworkMapper.homeworkToDto(homeworkRepository.findByGroupId(id));
    }

    public List<HomeworkDto> findByTeacherId(Long id){
        return homeworkMapper.homeworkToDto(homeworkRepository.findByTeacherId(id));
    }

    public ResponseEntity deleteById(Long id){
        homeworkRepository.delete(homeworkMapper.dtoToHomework(findById(id)));
        return ResponseEntity.ok().build();
    }

    public List<HomeworkDto> findByUserIdAndSubjectId(Long userId, Long subjectId){
        return homeworkMapper.homeworkToDto(homeworkRepository.findByUserIdAndSubjectId(userId, subjectId));
    }

}
