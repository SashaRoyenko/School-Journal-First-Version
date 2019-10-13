package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String firstName;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String secondName;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String lastName;

    private Date birthDate;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    @Column(nullable = false)
    private String email;

    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    @Column(nullable = false)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private Group group;

    @OneToOne(cascade = CascadeType.ALL)
    private Parent parent;

    @Column(nullable = false, length = 100)
    private String login;
    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}")
    @Column(nullable = false)
    private String password;


//    @Enumerated(EnumType.STRING)
//    private Role role;
}
