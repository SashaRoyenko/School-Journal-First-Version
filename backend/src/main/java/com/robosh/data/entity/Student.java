package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.*;
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
                   Date birthDate, String login,
                   String password, String email,
                   String phone, Role role,
                   Address address, Group group, Boolean active){
        super(id, firstName, secondName, lastName, password, email, phone, role, active);
        this.birthDate = birthDate;
        this.address = address;
        this.group = group;
    }

    @Column(nullable = true)
    private Date birthDate;


    //todo replace
    @OneToOne
    @JoinColumn(name = "id_address", nullable = true)
    private Address address;

    //todo discuss
    @ManyToOne
    @JoinColumn(name = "id_class", nullable = true)
    private Group group;
}
