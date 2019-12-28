package com.robosh.controller;

import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.dto.StudentDto;
import com.robosh.data.entity.Rebuke;
import com.robosh.service.*;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

import static com.robosh.common_routes.Routes.STUDENT_MAPPING;

@Controller
@RequestMapping(STUDENT_MAPPING)
@PreAuthorize("hasAuthority('STUDENT')")
@AllArgsConstructor
public class StudentController {

    private static final String STUDENT_PROFILE = STUDENT_MAPPING + "/profile";
    private static final String STUDENT_HOMEWORK = STUDENT_MAPPING + "/hometasks";
    private static final String STUDENT_JOURNAL = STUDENT_MAPPING + "/journal";
    private static final String STUDENT_REBUKE = STUDENT_MAPPING + "/rebuke";

    private StudentService studentService;
    private ScheduleService scheduleService;
    private GroupService groupService;
    private HomeworkService homeworkService;
    private RebukeService rebukeService;

    @GetMapping(value = {"", STUDENT_PROFILE})
    public String studentPage(Model model, Principal principal){
        model.addAttribute("student", getStudentDto(principal));
        return "student/profile";
    }

    @GetMapping(value = {STUDENT_HOMEWORK})
    public String getStudentHomework(Model model, Principal principal){
        StudentDto studentDto = getStudentDto(principal);
        List<HomeworkDto> homeworkDtoList = homeworkService.findByGroupId(studentDto.getGroup().getId());
        model.addAttribute("student", studentDto);
        model.addAttribute("homeworkList", homeworkDtoList);
        return "student/hometask";
    }

    @GetMapping(value = {STUDENT_REBUKE})
    public String getStudentRebuke(Model model, Principal principal){
        StudentDto studentDto = getStudentDto(principal);
        List<Rebuke> rebukeList = rebukeService.findByStudentId(studentDto.getId());
        model.addAttribute("student", studentDto);
        model.addAttribute("rebukeList", rebukeList);
        return "student/rebuke";
    }

    private StudentDto getStudentDto(Principal principal){
        return studentService.findByEmail(principal.getName());
    }
}
