package com.robosh.data.mapping;

import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    TeacherDto teacherToDto(Teacher teacher);

    Teacher dtoToTeacher(TeacherDto teacherDto);

    List<TeacherDto> teachersToDto(List<Teacher> teachers);
}
