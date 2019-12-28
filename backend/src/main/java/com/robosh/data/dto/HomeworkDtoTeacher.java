package com.robosh.data.dto;

import lombok.Data;

@Data
public class HomeworkDtoTeacher {
    private Long id;

    private String task;

    private String deadline;

    private String subject;

    private String teacher;

    private String group;
}
