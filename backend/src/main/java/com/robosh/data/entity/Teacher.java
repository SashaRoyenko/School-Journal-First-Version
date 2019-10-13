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
@Entity(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String name;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String surname;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String middleName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    private String phoneNumber;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}")
    private String password;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    private String email;

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
