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
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    protected Long idPerson;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String secondName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Column(nullable = false, length = 100, unique = true)
    //todo regex
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
    @Column(nullable = false, unique = true)
    protected String email;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    @Column(nullable = false, unique = true)
    protected String phone;

    @Enumerated(EnumType.STRING)
    protected Role role;

    @Column(nullable = false)
    protected Boolean active;
}
