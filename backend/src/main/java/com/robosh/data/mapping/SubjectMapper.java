package com.robosh.data.mapping;

import com.robosh.data.dto.SubjectDto;
import com.robosh.data.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SubjectMapper {
    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    Subject dtoToSubject(SubjectDto subjectDto);

    SubjectDto subjectToDto(Subject subject);

    List<SubjectDto> subjectsToDto(List<Subject> subjects);
}
