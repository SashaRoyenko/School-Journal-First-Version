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
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        addTeacherProfileAttributes(model, teacher);
        return "teacher/profile";
    }

    private TeacherDto getTeacherDtoAndSetHeaderName(Model model, Principal principal) {
        TeacherDto teacher = teacherService.findTeacherByEmail(principal.getName());
        setHeaderName(model, teacher.getFirstName(), teacher.getLastName());
        return teacher;
    }

    private void addTeacherProfileAttributes(Model model, TeacherDto teacher) {
        System.out.println(teacher.getUrl());
        model.addAttribute("teacherDto", teacher);
    }

    @GetMapping("/schedule")
    public String schedule(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/schedule";
    }

    @GetMapping("/rebukes")
    public String rebukes(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/rebukes";
    }

    @GetMapping("/marks")
    public String marks(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/marks";
    }

    @GetMapping("/hometask")
    public String hometask(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/hometasks";
    }

    @GetMapping("/marks/add-mark")
    public String addMarkPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/add_mark";
    }

    @GetMapping("/rebukes/add-rebuke")
    public String addRebukesPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/add_rebuke";
    }

    @GetMapping("/hometask/add-hometask")
    public String addHomeTaskPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/add_hometask";
    }
}
