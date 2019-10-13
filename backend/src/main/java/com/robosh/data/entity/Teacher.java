package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Teacher extends User {

    @NotEmpty
    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty
    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String secondName;

    @NotEmpty
    @NotNull
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}")
    private String password;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @ManyToMany
    @JoinTable(
            name = "teacher_subjects",
            joinColumns = {@JoinColumn(name = "subject_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")}
    )
    private List<Subject> subjects;

    @NotNull
    @NotEmpty
    @NotBlank
    @OneToOne
    private Address address;
}
