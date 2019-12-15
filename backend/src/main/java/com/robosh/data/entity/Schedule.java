package com.robosh.data.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.DayOfWeek;
import java.util.List;

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
    @JoinColumn(name = "id_class", nullable = true)
    private Group group;

    @Pattern(regexp = "[\\d]+")
    private String cabinet;

    @NotNull
    private DayOfWeek dayOfWeek;

    @NotNull
    private Integer numberOfSubject;

    @NotNull
    @OneToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;
}
