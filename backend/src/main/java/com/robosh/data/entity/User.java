package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    protected Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    protected String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    protected String secondName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    protected String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    @Column(nullable = false, unique = true)
    protected String email;

    @NotNull
    @NotEmpty
    @NotBlank
//    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}")
    @Column(nullable = false)
    protected String password;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^\\+?3?8?(0\\d{9})$")
    @Column(nullable = false, unique = true)
    protected String phone;

    @Enumerated(EnumType.STRING)
    protected Role role;

    @Column(nullable = true) //changed from false to true to add user
    protected Boolean active = true;
}
