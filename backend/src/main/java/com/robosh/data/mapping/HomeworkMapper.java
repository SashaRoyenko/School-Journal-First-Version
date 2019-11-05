package com.robosh.data.mapping;

import com.robosh.data.entity.Homework;
import com.robosh.data.entity.HomeworkDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HomeworkMapper {
    HomeworkMapper INSTANCE = Mappers.getMapper(HomeworkMapper.class);

    HomeworkDto HomeworkToDto(Homework homework);

    Homework dtoToHomework(HomeworkDto homeworkDto);

    List<HomeworkDto> homeworkToDto(List<Homework> homework);

}
