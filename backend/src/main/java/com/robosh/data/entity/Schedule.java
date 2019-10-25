package com.robosh.data.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_schedule")
    private Long idSchedule;

    @OneToOne
    @JoinColumn(name = "id_group", nullable = true)
    private Group group;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String cabinet;

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
    @OneToMany
    private List<Subject> subjectList;

    @NotNull
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "id_person", nullable = true)
    private Teacher teacher;
}
