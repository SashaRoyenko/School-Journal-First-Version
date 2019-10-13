package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin extends User {
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String firstName;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String secondName;

    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String lastName;
}
