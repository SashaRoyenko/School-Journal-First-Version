package com.robosh.data.dto;

import com.robosh.data.enumeration.Role;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, includeFieldNames = true)
public class ParentDto extends UserDto {

    private String firstName2;

    private String secondName2;

    private String lastName2;

    private String email2;

    private String phone2;

    private List<StudentDto> students;

    private Role role = Role.PARENT;
}
