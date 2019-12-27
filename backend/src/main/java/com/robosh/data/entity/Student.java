package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Student extends User {

    @Builder
    public Student(Long id, String firstName,
                   String secondName, String lastName,
                   LocalDate birthDate, String password, String email,
                   String phone, Role role,
                   String address, Group group, Boolean active) {
        super(id, firstName, secondName, lastName, email, password, phone, role, active);
        this.birthDate = birthDate;
        this.address = address;
        this.group = group;
    }

    @Column(nullable = true)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotNull
    @NotBlank
    @NotEmpty
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_class", nullable = true)
    private Group group;
}
