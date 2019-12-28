package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.DayOfWeek;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_schedule")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_group", nullable = true)
    private Group group;

    @Pattern(regexp = "[\\d]+")
    private String cabinet;

    @NotNull
    @Enumerated
    private DayOfWeek dayOfWeek;

    @NotNull
    private Integer numberOfSubject;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;
}
