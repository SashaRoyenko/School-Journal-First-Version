package com.robosh.data.entity;

import com.robosh.data.enumeration.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(nullable = false, length = 100)
    protected String login;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}")
    @Column(nullable = false)
    protected String password;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    @Column(nullable = false)
    protected String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    @Column(nullable = false)
    protected String phone;

    @Enumerated(EnumType.STRING)
    protected Role role;
}
