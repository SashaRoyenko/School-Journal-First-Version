package com.robosh.data.mapping;

import com.robosh.data.dto.GroupDto;
import com.robosh.data.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    GroupDto groupToDto(Group group);

    Group dtoToGroup(GroupDto groupDto);
}
