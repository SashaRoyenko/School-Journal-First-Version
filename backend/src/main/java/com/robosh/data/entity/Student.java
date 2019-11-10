package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Student extends User {

    @Builder(builderMethodName = "studentBuilder")
    public Student(Long id, String firstName,
                   String secondName, String lastName,
                   Date birthDate, String password, String email,
                   String phone, Role role,
                   String address, Group group, Boolean active) {
        super(id, firstName, secondName, lastName, password, email, phone, role, active);
        this.birthDate = birthDate;
        this.address = address;
        this.group = group;
    }

    @Column(nullable = true)
    private Date birthDate;

    @NotNull
    @NotBlank
    @NotEmpty
    private String address;

    //todo discuss
    @ManyToOne
    @JoinColumn(name = "id_class", nullable = true)
    private Group group;
}
