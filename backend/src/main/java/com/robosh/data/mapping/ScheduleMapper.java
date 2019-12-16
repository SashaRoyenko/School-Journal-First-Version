package com.robosh.data.mapping;

import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.entity.Schedule;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "groupId", target = "group.id"),
            @Mapping(source = "cabinet", target = "cabinet"),
            @Mapping(source = "dayOfWeek", target = "dayOfWeek"),
            @Mapping(source = "numberOfSubject", target = "numberOfSubject"),
            @Mapping(source = "subjectId", target = "subject.id"),
            @Mapping(source = "teacherId", target = "teacher.id")
    })
    Schedule dtoToSchedule(ScheduleDto scheduleDto);

    @InheritInverseConfiguration
    ScheduleDto scheduleToDto(Schedule schedule);

    List<Schedule> dtoToSchedules(List<ScheduleDto> schedulesDto);
    List<ScheduleDto> schedulesToDto(List<Schedule> schedules);
}
