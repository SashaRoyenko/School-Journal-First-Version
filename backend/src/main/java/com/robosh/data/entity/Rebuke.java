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
@NoArgsConstructor
@AllArgsConstructor
public class Rebuke {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_rebuke")
    private Long id;

    @NotNull
    @NotBlank
    private String rebukeMessage;

    private Date rebukeDate;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "id_student")
    private  Student student;
}
