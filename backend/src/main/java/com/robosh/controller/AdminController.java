package com.robosh.controller;

import com.robosh.data.dto.GroupDto;
import com.robosh.data.dto.ParentDto;
import com.robosh.data.dto.StudentDto;
import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Parent;
import com.robosh.data.entity.Student;
import com.robosh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.robosh.common_routes.Routes.ADMIN_MAPPING;
import static com.robosh.common_routes.Routes.REDIRECT_URL;

@Controller
@RequestMapping(ADMIN_MAPPING)
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private static final String TEACHERS_MAPPING = "/teachers";
    private static final String STUDENTS_MAPPING = "/students";
    private static final String PARENTS_MAPPING = "/parents";
    private static final String SCHEDULE_MAPPING = "/schedule";
    private static final String GROUPS_MAPPING = "/groups";

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final ScheduleService scheduleService;
    private final GroupService groupService;

    @Autowired
    public AdminController(TeacherService teacherService, StudentService studentService, ParentService parentService, ScheduleService scheduleService, GroupService groupService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.scheduleService = scheduleService;
        this.groupService = groupService;
    }

    @GetMapping(value = {"", TEACHERS_MAPPING})
    public String getAllTeachers(Model model) {
        List<TeacherDto> teachers = teacherService.findAll();
        model.addAttribute("teacherList", teachers);

        return "admin/teachers";
    }

    @GetMapping(value = {TEACHERS_MAPPING + "/edit", TEACHERS_MAPPING + "/edit/{id}"})
    public String editTeacherById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            TeacherDto teacher = teacherService.findById(id.get());
            model.addAttribute("teacher", teacher);
        } else {
            model.addAttribute("teacher", new TeacherDto());
        }
        return "admin/add_teacher";
    }

    @PostMapping(value = TEACHERS_MAPPING + "/add")
    public String createOrUpdateTeacher(TeacherDto teacherDto) {
        if (teacherDto.getId() == null) {
            teacherService.save(teacherDto);
        } else {
            teacherService.update(teacherDto);
        }

        return REDIRECT_URL + ADMIN_MAPPING + TEACHERS_MAPPING;
    }

    @GetMapping(value = TEACHERS_MAPPING + "/delete/{id}")
    public String deleteTeacher(Model model, @PathVariable("id") Optional<Long> id) {

        id.ifPresent(teacherService::delete);
        return REDIRECT_URL + ADMIN_MAPPING + TEACHERS_MAPPING;
    }

    @GetMapping(value = {STUDENTS_MAPPING})
    public String getAllStudents(Model model) {
        List<StudentDto> students = studentService.findAll();
        model.addAttribute("studentList", students);

        return "admin/students";
    }

    @GetMapping(value = {STUDENTS_MAPPING + "/edit", STUDENTS_MAPPING + "/edit/{id}"})
    public String editStudentById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Student student = studentService.findById(id.get());
            model.addAttribute("student", student);
        } else {
            model.addAttribute("student", new Student());
        }

        List<GroupDto> groups = groupService.findAll();
        model.addAttribute("groups", groups);

        return "admin/add_student";
    }

    @PostMapping(value = STUDENTS_MAPPING + "/add")
    public String createOrUpdateStudent(StudentDto studentDto, String groupCode) {

        studentDto.setGroup(groupService.convertGroupDtoToEntity(groupService.findByCodeGroup(groupCode)));

        if (studentDto.getId() == null) {
            studentService.save(studentDto);
        } else {
            studentService.update(studentDto);
        }

        return REDIRECT_URL + ADMIN_MAPPING + STUDENTS_MAPPING;
    }

    @GetMapping(value = STUDENTS_MAPPING + "/delete/{id}")
    public String deleteStudent(Model model, @PathVariable("id") Optional<Long> id) {

        id.ifPresent(studentService::delete);
        return REDIRECT_URL + ADMIN_MAPPING + STUDENTS_MAPPING;
    }

    @GetMapping(value = {PARENTS_MAPPING})
    public String getAllParents(Model model) {
        List<ParentDto> parents = parentService.findAll();
        model.addAttribute("parentList", parents);

        return "admin/parents";
    }

    @GetMapping(value = {PARENTS_MAPPING + "/edit", PARENTS_MAPPING + "/edit/{id}"})
    public String editParentById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            Parent parent = parentService.findById(id.get());
            model.addAttribute("parent", parent);
        } else {
            model.addAttribute("parent", new Parent());
        }

        return "admin/add_parents";
    }

    @PostMapping(value = PARENTS_MAPPING + "/add")
    public String createOrUpdateParent(ParentDto parentDto) {

        if (parentDto.getId() == null) {
            parentService.save(parentDto);
        } else {
            parentService.update(parentDto);
        }

        return REDIRECT_URL + ADMIN_MAPPING + PARENTS_MAPPING;
    }

    @GetMapping(value = PARENTS_MAPPING + "/delete/{id}")
    public String deleteParent(Model model, @PathVariable("id") Optional<Long> id) {

        id.ifPresent(parentService::delete);
        return REDIRECT_URL + ADMIN_MAPPING + PARENTS_MAPPING;
    }

}
