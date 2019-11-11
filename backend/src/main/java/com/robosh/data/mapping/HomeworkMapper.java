package com.robosh.data.mapping;

import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.entity.Homework;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HomeworkMapper {
    HomeworkMapper INSTANCE = Mappers.getMapper(HomeworkMapper.class);

    @Mappings({
            @Mapping(source = "subjectId", target = "subject.id"),
            @Mapping(source = "teacherId", target = "teacher.id"),
            @Mapping(source = "groupId", target = "group.id"),
    })
    Homework dtoToHomework(HomeworkDto homeworkDto);

    @InheritInverseConfiguration
    HomeworkDto homeworkToDto(Homework homework);

    List<HomeworkDto> homeworkToDto(List<Homework> homework);

}
