package com.robosh.data.mapping;

import com.robosh.data.dto.UserDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
//@Component
public interface UserMapper {
//    @Mappings({
//            @Mapping(source = "idPerson", target = "idPerson"),
//            @Mapping(source = "firstName", target = "firstName"),
//            @Mapping(source = "secondName", target = "secondName"),
//            @Mapping(source = "lastName", target = "lastName"),
//            @Mapping(source = "login", target = "login"),
//            @Mapping(source = "password", target = "password"),
//            @Mapping(source = "email", target = "email"),
//            @Mapping(source = "phone", target = "phone"),
//            @Mapping(source = "role", target = "role"),
//    })
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto userToDto(com.robosh.data.entity.User user);

//    @InheritInverseConfiguration
    com.robosh.data.entity.User dtoToUser(UserDto userDto);

}
