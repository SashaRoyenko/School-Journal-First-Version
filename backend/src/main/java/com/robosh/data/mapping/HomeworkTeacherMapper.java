package com.robosh.data.mapping;

import com.robosh.data.dto.HomeworkDtoTeacher;
import com.robosh.data.entity.Homework;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface HomeworkTeacherMapper {
    HomeworkTeacherMapper INSTANCE = Mappers.getMapper(HomeworkTeacherMapper.class);

    Homework dtaToHomework(HomeworkDtoTeacher homeworkDtoTeacher);

    HomeworkDtoTeacher homeworkToDto(Homework homework);

    List<HomeworkDtoTeacher> homeworkToDto(List<Homework> homework);
}
