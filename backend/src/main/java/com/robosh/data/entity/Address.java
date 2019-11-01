package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_address")
    private Long id;

    @Pattern(regexp = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)+")
    @Column(nullable = false)
    private String street;

    @Pattern(regexp = "^\\d+/?\\d*[a-zA-Z]?(?<!/)$")
    @Column(nullable = false)
    private String houseNumber;

    @Pattern(regexp = "[\\d]+")
    @Column(nullable = false)
    private String roomNumber;
}
