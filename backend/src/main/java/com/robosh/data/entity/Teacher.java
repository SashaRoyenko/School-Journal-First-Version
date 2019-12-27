package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Teacher extends User {

    @Builder
    public Teacher(Long id, String firstName,
                   String secondName, String lastName, String password,
                   String email, String phone, String url, Role role,
                   String address, Boolean active) {
        super(id, firstName, secondName, lastName, email, password, phone, url, role, active);
        this.address = address;
    }

    @NotBlank
    //todo add regex
    private String address;
}
