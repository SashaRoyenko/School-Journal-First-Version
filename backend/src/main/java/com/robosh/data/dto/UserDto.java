package com.robosh.data.dto;

import com.robosh.data.enumeration.Role;
import lombok.Data;

@Data
public class UserDto {
    protected Long id;

    protected String firstName;

    protected String secondName;

    protected String lastName;

    protected String email;

    protected String password;

    protected String phone;

    protected String url;

    protected Role role;
}
