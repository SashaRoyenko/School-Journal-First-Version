package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mark")
    private Long id;

    @Column(name = "mark_value")
    private int value;

    private Long subjectId;

    private Long teacherId;

    private Long studentId;
}
