package com.robosh.data.mapping;

import com.robosh.data.dto.GroupDto;
import com.robosh.data.dto.SubjectDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    GroupDto groupToDto(Group group);

    Group dtoToGroup(GroupDto groupDto);

    List<GroupDto> groupsToDto(List<Group> groups);

    List<SubjectDto> subjectsToDto(List<Subject> subjects);
}
