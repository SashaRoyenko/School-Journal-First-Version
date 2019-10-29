package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


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
                   Address address, Boolean active) {
        super(id, firstName, secondName, lastName, login, password, email, phone, role, active);
        this.address = address;
    }

    @NotNull
    @NotEmpty
    @NotBlank
    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;
}
