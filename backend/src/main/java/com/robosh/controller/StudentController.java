package com.robosh.controller;

import com.robosh.data.dto.GroupDto;
import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.dto.StudentDto;
import com.robosh.data.dto.SubjectDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Rebuke;
import com.robosh.data.entity.Schedule;
import com.robosh.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.time.DayOfWeek;
import java.util.*;

import static com.robosh.common_routes.Routes.STUDENT_MAPPING;

@Controller
@RequestMapping(STUDENT_MAPPING)
@PreAuthorize("hasAuthority('STUDENT')")
@AllArgsConstructor
public class StudentController {

    private static final String STUDENT_PROFILE = "/profile";
    private static final String STUDENT_HOMEWORK = "/hometasks";
    private static final String STUDENT_JOURNAL = "/journal";
    private static final String STUDENT_REBUKE = "/rebuke";
    private static final String STUDENT_SCHEDULE = "/schedule";

    private StudentService studentService;
    private ScheduleService scheduleService;
    private GroupService groupService;
    private HomeworkService homeworkService;
    private RebukeService rebukeService;
    private SubjectService subjectService;

    @GetMapping(value = {"", STUDENT_PROFILE})
    public String studentPage(Model model, Principal principal) {
        model.addAttribute("student", getStudentDto(principal));
        return "student/profile";
    }

    @GetMapping(value = {STUDENT_HOMEWORK, STUDENT_HOMEWORK + "/{id}"})
    public String getStudentHomework(Model model, Principal principal, @PathVariable("id") Optional<Long> id) {
        StudentDto studentDto = getStudentDto(principal);
        List<SubjectDto> subjectList = subjectService.findSubjectsByGroupId(studentDto.getGroup().getId());
        Long subjectId =  id.orElse(subjectList.get(0).getId());
        List<HomeworkDto> homeworkDtoList = homeworkService.findByGroupIdAndSubjectId(studentDto.getGroup().getId(),
               subjectId);
        model.addAttribute("id", subjectId);
        SubjectDto focusSubject = subjectService.findById(subjectId);
        model.addAttribute("student", studentDto);
        model.addAttribute("subjects", subjectList);
        model.addAttribute("focusSubject", focusSubject);
        model.addAttribute("homeworkList", homeworkDtoList);
        return "student/hometask";
    }

    @GetMapping(value = {STUDENT_REBUKE})
    public String getStudentRebuke(Model model, Principal principal) {
        StudentDto studentDto = getStudentDto(principal);
        List<Rebuke> rebukeList = rebukeService.findByStudentId(studentDto.getId());
        model.addAttribute("student", studentDto);
        model.addAttribute("rebukeList", rebukeList);
        return "student/rebukes";
    }

    @GetMapping(value = {STUDENT_SCHEDULE})
    public String getStudentSchedule(Model model, Principal principal){
        StudentDto studentDto = getStudentDto(principal);
        Group group = studentDto.getGroup();

        final List<Schedule> schedules = scheduleService.findByGroupId(group.getId());
        final Map<DayOfWeek, List<Schedule>> scheduleForEachDay = scheduleService.getScheduleForEachDay(schedules);


        model.addAttribute("scheduleMap", scheduleService.getIntegerSchedule(scheduleForEachDay));
        model.addAttribute("student", studentDto);

        return "student/schedule";
    }


    private StudentDto getStudentDto(Principal principal) {
        return studentService.findByEmail(principal.getName());
    }
}
