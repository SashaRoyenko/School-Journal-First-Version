package com.robosh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;

//    todo add ukrainian localization
    @Pattern(regexp = "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)+")
    private String street;

//    todo add ukrainian localization
    @Pattern(regexp = "^\\d+/?\\d*[a-zA-Z]?(?<!/)$")
    private String houseNumber;

    @Pattern(regexp = "[\\d]+")
    private String roomNumber;
}
