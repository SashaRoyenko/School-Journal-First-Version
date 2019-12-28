package com.robosh.controller;

import com.robosh.data.dto.*;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Parent;
import com.robosh.data.entity.Schedule;
import com.robosh.data.entity.Student;
import com.robosh.service.*;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
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
    private static final String SUBJECTS_MAPPING = "/subjects";

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final ScheduleService scheduleService;
    private final GroupService groupService;
    private final SubjectService subjectService;

    @Autowired
    public AdminController(TeacherService teacherService, StudentService studentService, ParentService parentService, ScheduleService scheduleService, GroupService groupService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
        this.scheduleService = scheduleService;
        this.groupService = groupService;
        this.subjectService = subjectService;
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

    @GetMapping(value = {SCHEDULE_MAPPING, SCHEDULE_MAPPING + "/{groupId}"})
    public String getAllSchedules(Model model, @PathVariable Optional<Long> groupId) {

        if (groupId.isPresent()) {
            model.addAttribute("IsGroupExists", false);
        } else {
            List<ScheduleDto> schedules = scheduleService.findByGroupId(groupId.get());
            model.addAttribute("ScheduleList", schedules);
        }

        List<GroupDto> groups = groupService.findAll();
        model.addAttribute("groups", groups);

        return "admin/schedule";
    }

    @GetMapping(value = {SCHEDULE_MAPPING + "/edit", SCHEDULE_MAPPING + "/edit/{dayOfWeek}"})
    public String createOrEditSchedule(Model model, @PathVariable Optional<Integer> dayOfWeek) {
//        if (dayOfWeek.isPresent()) {
//            List<ScheduleDto> schedules = scheduleService.findByDay(DayOfWeek.of(dayOfWeek.get()));
//            model.addAttribute("schedules", schedules);
//        } else {
//            model.addAttribute("schedules", new ArrayList<ScheduleDto>(8));
//        }

        return "admin/add_schedule";
    }

    @PostMapping(value = {SCHEDULE_MAPPING + "/add"})
    public String addSchedule(List<ScheduleDto> scheduleDtos) {
        for (ScheduleDto schedule : scheduleDtos) {
            if (schedule.getId() == null) {
                scheduleService.save(schedule);
            } else {
                scheduleService.update(schedule);
            }
        }

        return REDIRECT_URL + ADMIN_MAPPING + SCHEDULE_MAPPING;
    }

    @GetMapping(value = {SCHEDULE_MAPPING + "delete/{dayOfWeek}"})
    public String deleteSchedule(Model model, @PathVariable Optional<Integer> dayOfWeek) {

//        if (dayOfWeek.isPresent()) {
//            List<ScheduleDto> schedules = scheduleService.findByDay(DayOfWeek.of(dayOfWeek.get()));
//            for (ScheduleDto schedule : schedules) {
//                scheduleService.delete(schedule.getId());
//            }
//        }

        return REDIRECT_URL + ADMIN_MAPPING + SCHEDULE_MAPPING;

    }

    @GetMapping(value = {GROUPS_MAPPING})
    public String getAllGroups(Model model) {
        List<GroupDto> groups = groupService.findAll();
        model.addAttribute("groupsList", groups);

        return "admin/groups";
    }

    @GetMapping(value = {GROUPS_MAPPING + "/edit"})
    public String createOrEditGroup(Model model) {

        model.addAttribute("group", new Group());

        return "admin/add_schedule";
    }

    @PostMapping(value = {GROUPS_MAPPING + "/add"})
    public String addGroup(GroupDto groupDto) {

        groupService.save(groupDto);

        return REDIRECT_URL + ADMIN_MAPPING + GROUPS_MAPPING;
    }

    @GetMapping(value = {GROUPS_MAPPING + "/delete/{id}"})
    public String deleteGroup(Model model, @PathVariable Optional<Long> id) {
        id.ifPresent(groupService::delete);

        return REDIRECT_URL + ADMIN_MAPPING + GROUPS_MAPPING;
    }


    @GetMapping(value = {SUBJECTS_MAPPING})
    public String getAllSubjects(Model model) {
        List<SubjectDto> subjects = subjectService.findAll();
        model.addAttribute("subjectList", subjects);

        return "admin/lessons";
    }


}
