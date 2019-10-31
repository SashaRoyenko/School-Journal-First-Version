package com.robosh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private Long id;

    @Pattern(regexp = "\\d{1,2}+[-]+[А-ЯЇ]")
    private String groupCode;

}
