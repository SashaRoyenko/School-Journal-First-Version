package com.robosh.controller;

import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Schedule;
import com.robosh.data.entity.Subject;
import com.robosh.service.HomeworkService;
import com.robosh.service.ScheduleService;
import com.robosh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

import static com.robosh.common_routes.Routes.TEACHER_MAPPING;

@Controller
@RequestMapping(TEACHER_MAPPING)
@PreAuthorize("hasAuthority('ADMIN')")
public class TeacherController {
    private ScheduleService scheduleService;
    private TeacherService teacherService;
    private HomeworkService homeworkService;

    @Autowired
    public TeacherController(ScheduleService scheduleService, TeacherService teacherService, HomeworkService homeworkService) {
        this.scheduleService = scheduleService;
        this.teacherService = teacherService;
        this.homeworkService = homeworkService;
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
        List<Schedule> schedules = scheduleService.getScheduleByTeacherId(teacher.getId());
        model.addAttribute("schedule_show", schedules);
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
        List<Subject> subjects = scheduleService.getSubjectsByTeacherId(teacher.getId());
        model.addAttribute("subjects", subjects);

        List<Group> groups = scheduleService.getGroupsByTeacherId(teacher.getId());
        model.addAttribute("groups", groups);

        return "teacher/hometasks";
    }

    @GetMapping("/hometask/add-hometask")
    public String addHomeTaskPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        return "teacher/add_hometask";
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
}
