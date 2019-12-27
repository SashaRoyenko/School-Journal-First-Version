package com.robosh.data.dto;

import com.robosh.data.entity.Subject;
import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, includeFieldNames = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto extends UserDto {

    @NotNull
    private String address;

    private Subject subject;

    private Role role = Role.TEACHER;
}
