package com.robosh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkDto {

    private Long id;

    private String deadline;

    private String task;

    private Long subjectId;

    private Long teacherId;

    private Long groupId;
}
