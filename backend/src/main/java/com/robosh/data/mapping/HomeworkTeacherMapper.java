package com.robosh.data.mapping;

import com.robosh.data.dto.HomeworkDtoTeacher;
import com.robosh.data.entity.Homework;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HomeworkTeacherMapper {
    HomeworkTeacherMapper INSTANCE = Mappers.getMapper(HomeworkTeacherMapper.class);

    Homework dtoToHomework(HomeworkDtoTeacher homeworkDtoTeacher);

    HomeworkDtoTeacher homeworkToDto(Homework homework);

    List<HomeworkDtoTeacher> homeworkToDto(List<Homework> homework);
}
