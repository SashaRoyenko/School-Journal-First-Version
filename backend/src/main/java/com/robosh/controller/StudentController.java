package com.robosh.controller;

import com.robosh.data.dto.StudentDto;
import com.robosh.service.GroupService;
import com.robosh.service.ScheduleService;
import com.robosh.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.security.Principal;

import static com.robosh.common_routes.Routes.STUDENT_MAPPING;

@Controller
@RequestMapping(STUDENT_MAPPING)
@PreAuthorize("hasAuthority('STUDENT')")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;
    private ScheduleService scheduleService;
    private GroupService groupService;

    @GetMapping
    public String studentPage(Model model, Principal principal){
        model.addAttribute("student", getStudentDto(principal));
        return "student/profile";
    }

    private StudentDto getStudentDto(Principal principal){
        return studentService.findByEmail(principal.getName());
    }
}
