package com.robosh.data.dto;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto extends UserDto {

    @NotNull
    private String address;

    private Role role = Role.TEACHER;
}
