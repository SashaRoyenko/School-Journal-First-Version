package com.robosh.data.entity;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String schoolClass;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String dayOfWeek;

    @NotNull
    @NotEmpty
    private Integer numberOfSubject;

    @NotNull
    @NotEmpty
    @ManyToOne
    private Subject subject;

    @NotNull
    @NotEmpty
    @ManyToOne
    private Teacher teacher;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String cabinet;
}


