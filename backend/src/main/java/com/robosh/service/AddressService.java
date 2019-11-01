package com.robosh.service;

import com.robosh.data.dto.AddressDto;
import com.robosh.data.mapping.AddressMapper;
import com.robosh.data.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressDto save(AddressDto addressDto) {
        return addressMapper.addressToDto(addressRepository.save(addressMapper.dtoToAddress(addressDto)));
    }
}
