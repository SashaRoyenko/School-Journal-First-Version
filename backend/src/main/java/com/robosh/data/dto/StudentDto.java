package com.robosh.data.dto;

import com.robosh.data.entity.Address;
import com.robosh.data.entity.Group;
import com.robosh.data.enumeration.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, includeFieldNames = true)
public class StudentDto extends UserDto {
    private Date birthDate;

    private Address address;

    private Group group;

    private Role role = Role.STUDENT;
}
