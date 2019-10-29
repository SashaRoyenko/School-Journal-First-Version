package com.robosh.data.mapping;

import com.robosh.data.dto.AddressDto;
import com.robosh.data.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto addressToDto(Address address);

    Address dtoToAddress(AddressDto addressDto);
}
