package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
                   Address address, Boolean active){
        super(id, firstName, secondName, lastName, login, password, email, phone, role, active);
        this.birthDate = birthDate;
        this.address = address;
    }

    @Column(nullable = true)
    private Date birthDate;

    @OneToOne
    @JoinColumn(name = "id_address", nullable = true)
    private Address address;
}
