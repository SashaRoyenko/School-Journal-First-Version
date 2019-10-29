package com.robosh.data.dto;

import com.robosh.data.entity.Address;
import com.robosh.data.enumeration.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.PostConstruct;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, includeFieldNames = true)
public class TeacherDto extends UserDto {
    private Address address;

    @PostConstruct
    public void changeRole() {
        this.role = Role.TEACHER;
    }
}
