package com.robosh.data.dto;

import com.robosh.data.entity.Address;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Parent;
import com.robosh.data.enumeration.Role;
import lombok.Data;

import javax.annotation.PostConstruct;
import java.util.Date;

@Data
public class StudentDto extends UserDto{
    private Date birthDate;

    private Address address;

    private Group group;

    private Parent parent;

    @PostConstruct
    public void changeRole() {
        this.role = Role.STUDENT;
    }
}
