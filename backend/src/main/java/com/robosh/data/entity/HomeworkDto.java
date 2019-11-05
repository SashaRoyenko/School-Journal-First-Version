package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkDto {

    private Long id;

    private Date deadline;

    private String task;

    private Subject subject;

    private Teacher teacher;
}
