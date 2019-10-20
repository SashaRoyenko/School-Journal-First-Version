package com.robosh.data.entity;

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
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Long idAddress;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String street;

    @NotNull
    @NotEmpty
    @NotBlank
    //todo add regex here
    @Column(nullable = false)
    private String houseNumber;

    @NotNull
    @NotEmpty
    @NotBlank
    //todo add regex here
    @Column(nullable = false)
    private String roomNumber;
}
