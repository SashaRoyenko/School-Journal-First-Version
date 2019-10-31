package com.robosh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto {

    private Long id;

    @Pattern(regexp = "[А-ЯЇ]+[А-ЯЇа-яЇ\\s]{5,}")
    private String name;
}
