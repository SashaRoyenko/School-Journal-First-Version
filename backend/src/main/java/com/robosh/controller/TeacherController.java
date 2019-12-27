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

    @GetMapping("/marks")
    public String marks() {
        return "teacher/marks";
    }

    @GetMapping("/hometask")
    public String hometask() {
        return "teacher/hometasks";
    }

    @GetMapping("/marks/add-mark")
    public String addMarkPage() {
        return "teacher/add_mark";
    }

    @GetMapping("/rebukes/add-rebuke")
    public String addRebukesPage() {
        return "teacher/add_rebuke";
    }

    @GetMapping("/hometask/add-hometask")
    public String addHomeTaskPage() {
        return "teacher/add_hometask";
    }
}
