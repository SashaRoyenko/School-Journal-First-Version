package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String firstName1;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String secondName1;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String lastName1;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String firstName2;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String secondName2;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String lastName2;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    @Column(nullable = false)
    private String email1;

    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    private String email2;

    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    @Column(nullable = false)
    private String phone1;

    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    @Column(nullable = false)
    private String phone2;

    @Column(nullable = false, length = 100)
    private String login;

    //    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}")
    @Column(nullable = false)
    private String password;


//    @Enumerated(EnumType.STRING)
//    private Role role;
}
