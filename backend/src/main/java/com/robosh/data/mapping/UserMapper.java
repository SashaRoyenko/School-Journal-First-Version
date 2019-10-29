package com.robosh.data.mapping;

import com.robosh.data.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto userToDto(com.robosh.data.entity.User user);

    com.robosh.data.entity.User dtoToUser(UserDto userDto);

}
