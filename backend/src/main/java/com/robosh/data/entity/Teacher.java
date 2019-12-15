package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
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
    public Teacher(Long id, String firstName, Subject subject,
                   String secondName, String lastName, String password,
                   String email, String phone, Role role,
                   String address, Boolean active) {
        super(id, firstName, secondName, lastName, password, email, phone, role, active);
        this.address = address;
    }

    @NotBlank
    //todo add regex
    private String address;

    @OneToMany
    @JoinColumn(name = "id_subject")
    private List<Subject> subjects;
}
