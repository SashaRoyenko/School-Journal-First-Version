package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Student extends User {

    @Builder(builderMethodName = "studentBuilder")
    public Student(Long id, String firstName,
                   String secondName, String lastName,
                   Date birthDate, Group group,
                   String login, String password,
                   String email, String phone,
                   Parent parent, Role role,
                   Address address, Boolean active){
        super(id, firstName, secondName, lastName, login, password, email, phone, role, active);
        this.birthDate = birthDate;
        this.address = address;
        this.group = group;
        this.parent = parent;
    }

    @Column(nullable = true)
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "id_address", nullable = true)
    private Address address;

    @OneToOne
    @JoinColumn(name = "id_group", nullable = true)
    private Group group;

    @OneToOne
    @JoinColumn(name = "id_person", nullable = true)
    private Parent parent;
}
