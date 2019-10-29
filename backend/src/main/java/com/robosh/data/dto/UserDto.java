package com.robosh.data.dto;

import com.robosh.data.enumeration.Role;
import lombok.Data;

@Data
public class UserDto {

    protected Long idPerson;

    protected String firstName;

    protected String secondName;

    protected String lastName;

    protected String login;

    protected String password;

    protected String email;

    protected String phone;

    protected Role role;

}
