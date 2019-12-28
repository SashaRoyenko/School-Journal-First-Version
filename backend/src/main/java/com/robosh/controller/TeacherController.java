package com.robosh.controller;

import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.dto.RebukeDto;
import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Homework;
import com.robosh.data.entity.Schedule;
import com.robosh.data.entity.Subject;
import com.robosh.service.HomeworkService;
import com.robosh.service.ScheduleService;
import com.robosh.service.StudentService;
import com.robosh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

import static com.robosh.common_routes.Routes.REDIRECT_URL;
import static com.robosh.common_routes.Routes.TEACHER_MAPPING;

@Controller
@RequestMapping(TEACHER_MAPPING)
@PreAuthorize("hasAuthority('ADMIN')")
public class TeacherController {
    private ScheduleService scheduleService;
    private TeacherService teacherService;
    private HomeworkService homeworkService;
    private StudentService studentService;

    @Autowired
    public TeacherController(ScheduleService scheduleService, TeacherService teacherService, HomeworkService homeworkService, StudentService studentService) {
        this.scheduleService = scheduleService;
        this.teacherService = teacherService;
        this.homeworkService = homeworkService;
        this.studentService = studentService;
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
        addTeacherProfileAttributes(model, teacher);
        List<Schedule> schedules = scheduleService.getScheduleByTeacherId(teacher.getId());

        final Map<DayOfWeek, List<Schedule>> scheduleForEachDay = scheduleService.getScheduleForEachDay(schedules);


        final Map<Integer, List<Schedule>> integerSchedule = scheduleService.getIntegerSchedule(scheduleForEachDay);
        model.addAttribute("scheduleMap", integerSchedule);

        return "teacher/schedule";
    }

    @GetMapping("/rebukes")
    public String rebukes(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        addTeacherProfileAttributes(model, teacher);

        return "teacher/rebukes";
    }

    @GetMapping("/marks")
    public String marks(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        addTeacherProfileAttributes(model, teacher);



        return "teacher/marks";
    }

    @GetMapping("/hometask")
    public String hometask(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        addTeacherProfileAttributes(model, teacher);

        List<Subject> subjects = scheduleService.getSubjectsByTeacherId(teacher.getId());
        model.addAttribute("subjects", subjects);

        List<Group> groups = scheduleService.getGroupsByTeacherId(teacher.getId());
        model.addAttribute("groups", groups);

        model.addAttribute("homeworks", homeworkService.findByGroupId(groups.get(0).getId()));
        return "teacher/hometasks";
    }

    @GetMapping("/hometask/add-hometask")
    public String addHomeTaskPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);

        addTeacherProfileAttributes(model, teacher);
        model.addAttribute("homework", new Homework());
        model.addAttribute("groups", scheduleService.getGroupsByTeacherId(teacher.getId()));
        return "teacher/add_hometask";
    }

    @PostMapping(value = "/hometask/add")
    public String addHometask(HomeworkDto homeworkDto, Principal principal, Model model) {
        TeacherDto teacher = teacherService.findTeacherByEmail(principal.getName());
        addTeacherProfileAttributes(model, teacher);
        List<Subject> subjects = scheduleService.getSubjectsByTeacherId(teacher.getId());
        homeworkDto.setSubjectId(subjects.get(0).getId());
        List<Group> groups = scheduleService.getGroupsByTeacherId(teacher.getId());
        homeworkDto.setGroupId(groups.get(0).getId());
        homeworkDto.setTeacherId(teacherService.convertDtoToTeacher(teacher).getId());

        homeworkService.save(homeworkDto);
        return REDIRECT_URL + TEACHER_MAPPING + "/hometask/add-hometask";
    }

    @GetMapping("/marks/add-mark")
    public String addMarkPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        addTeacherProfileAttributes(model, teacher);

        return "teacher/add_mark";
    }

    @GetMapping("/rebukes/add-rebuke")
    public String addRebukesPage(Model model, Principal principal) {
        TeacherDto teacher = getTeacherDtoAndSetHeaderName(model, principal);
        addTeacherProfileAttributes(model, teacher);

//        model.addAttribute("students", studentService.findAll());
        return "teacher/add_rebuke";
    }

    @PostMapping("/make-rebuke")
    public String makeRebuke(RebukeDto rebuke) {
        System.out.println();
        System.out.println(rebuke);
        System.out.println();

        return "redirect:/e-journal/teacher/rebukes/add-rebuke";
    }
}
