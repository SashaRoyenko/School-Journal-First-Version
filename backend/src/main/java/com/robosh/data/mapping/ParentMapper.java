package com.robosh.data.mapping;

import com.robosh.data.dto.ParentDto;
import com.robosh.data.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ParentMapper {
    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);

    Parent dtoToParent(ParentDto parentDto);

    ParentDto parentToDto(Parent parent);

    List<ParentDto> parentsToDto(List<Parent> parents);
}
