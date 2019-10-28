package com.robosh.data.dto;

import com.robosh.data.enumeration.Role;
import lombok.Data;

import javax.annotation.PostConstruct;

@Data
public class ParentDto extends UserDto {

    private String firstName2;

    private String secondName2;

    private String lastName2;

    private String email2;

    private String phone2;
//    todo what to do with this field?
//    private List<StudentDto> students;

    @PostConstruct
    public void changeRole() {
        this.role = Role.PARENT;
    }

}
