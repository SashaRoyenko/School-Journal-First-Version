package com.robosh.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.robosh.common_routes.Routes.TEACHER_MAPPING;

@Controller
@RequestMapping(TEACHER_MAPPING)
@PreAuthorize("hasAuthority('ADMIN')")
public class TeacherController {

    @GetMapping("")
    public String teacherProfile() {
        return "teacher/profile";
    }

    @GetMapping("/rebukes")
    public String rebukes() {
        return "teacher/rebukes";
    }
}
