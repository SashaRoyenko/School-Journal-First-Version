package com.robosh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.DayOfWeek;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDto {
    private Long id;

    private Long groupId;

    @Pattern(regexp = "[\\d]+")
    private String cabinet;

    @NotNull
    private DayOfWeek dayOfWeek;

    @NotNull
    private Integer numberOfSubject;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long teacherId;
}
