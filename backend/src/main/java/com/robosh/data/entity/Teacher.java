package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_address")
    private Address address;
}
