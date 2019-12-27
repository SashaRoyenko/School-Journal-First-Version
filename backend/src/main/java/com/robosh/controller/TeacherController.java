package com.robosh.controller;

import com.robosh.data.dto.TeacherDto;
import com.robosh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static com.robosh.common_routes.Routes.TEACHER_MAPPING;

@Controller
@RequestMapping(TEACHER_MAPPING)
@PreAuthorize("hasAuthority('ADMIN')")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    private void setHeaderName(Model model, String name, String surname) {
        model.addAttribute("teacherName", name + " " + surname);
    }

    @GetMapping("")
    public String showTeacherProfile(Model model, Principal principal) {
        TeacherDto teacher = teacherService.findTeacherByEmail(principal.getName());
        setHeaderName(model, teacher.getFirstName(), teacher.getLastName());
        addTeacherProfileAttributes(model, teacher);
        return "teacher/profile";
    }

    private void addTeacherProfileAttributes(Model model, TeacherDto teacher) {
        System.out.println(teacher.getUrl());
        model.addAttribute("teacherDto", teacher);
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "teacher/schedule";
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
