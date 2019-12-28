package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_homework")
    private Long id;

    @NotNull
    @NotBlank
    private String task;

    private String deadline;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "id_class")
    private  Group group;
}
