package com.robosh.data.mapping;

import com.robosh.data.dto.ParentDto;
import com.robosh.data.entity.Parent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ParentMapper {
    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);

    ParentDto parentToDto(Parent parent);

    Parent dtoToParent(ParentDto parentDto);
}
