package com.robosh.data.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parent extends User {
    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String firstName1;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String secondName1;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    @Column(nullable = false)
    private String lastName1;

    @NotEmpty
    @NotBlank
    @Nullable
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String firstName2;

    @NotBlank
    @Nullable
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String secondName2;

    @NotEmpty
    @NotBlank
    @Nullable
    @Pattern(regexp = "[A-za-z\\p{IsCyrillic}.'-]{3,20}")
    private String lastName2;

    @NotEmpty
    @NotBlank
    @Nullable
    @Pattern(regexp = "[A-Za-z0-9+_.-]+@[a-z.-]+\\.[a-z]{2,8}")
    private String email2;

    @Nullable
    @Pattern(regexp = "^(\\+38)(\\(0\\d{2}\\))(\\d){3}(\\-\\d{2}){2}$")
    @Column(nullable = false)
    private String phone2;

    @OneToMany
    private List<Student> students;

}
