package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true, includeFieldNames = true)
@Entity
public class Parent extends User {

    @Builder
    public Parent(Long id, String firstName,
                  String secondName, String lastName,
                  String password, String email, String phone, String url,
                  Role role, String firstName2,
                  String secondName2, String lastName2,
                  String email2, String phone2,
                  List<Student> students, Boolean active) {
        super(id, firstName, secondName, lastName, email, password, phone, url, role, active);
        this.firstName2 = firstName2;
        this.secondName2 = secondName2;
        this.lastName2 = lastName2;
        this.email2 = email2;
        this.phone2 = phone2;
        this.students = students;
    }

    @Pattern(regexp = "([A-za-z\\p{IsCyrillic}.'-]{3,20})*")
    private String firstName2;

    @Pattern(regexp = "([A-za-z\\p{IsCyrillic}.'-]{3,20})*")
    private String secondName2;

    @Pattern(regexp = "([A-za-z\\p{IsCyrillic}.'-]{3,20})*")
    private String lastName2;

    @Pattern(regexp = "([A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8})*")
    private String email2;

    @Pattern(regexp = "(^\\+?3?8?(0\\d{9})$)*")
    private String phone2;

    @OneToMany
    @ElementCollection
    private List<Student> students;
}
