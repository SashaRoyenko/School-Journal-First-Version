package com.robosh.data.dto;

import com.robosh.data.enumeration.Role;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {
//todo add validation
    protected Long id;

    protected String firstName;

    protected String secondName;

    protected String lastName;

    protected String email;

    @NotNull
    protected String password;

    protected String phone;

    protected Role role;
}
