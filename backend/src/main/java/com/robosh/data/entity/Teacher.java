package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Teacher extends User {

    @Builder(builderMethodName = "teacherBuilder")
    public Teacher(Long id, String firstName,
                   String secondName, String lastName,
                   String login, String password,
                   String email, String phone, Role role,
                   String address, Boolean active) {
        super(id, firstName, secondName, lastName, password, email, phone, role, active);
        this.address = address;
    }

    @NotBlank
    //todo add regex
    private String address;
}
