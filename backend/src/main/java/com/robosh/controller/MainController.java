package com.robosh.controller;

import com.robosh.data.dto.SubjectDto;
import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.User;
import com.robosh.data.enumeration.Role;
import com.robosh.service.SubjectService;
import com.robosh.service.TeacherService;
import com.robosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class MainController {
    private UserService userService;
    private SubjectService subjectService;
    private TeacherService teacherService;

    @Autowired
    public MainController(UserService userService, SubjectService subjectService, TeacherService teacherService) {
        this.userService = userService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
    }


    @GetMapping("/")
    public String getMain() {
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @PostMapping("/user/save")
    public void saveUser() {
        User user = new User();
        user.setFirstName("Admin");
        user.setSecondName("Admin");
        user.setLastName("Admin");
        user.setEmail("admin@admin.com");
        user.setPhone("+380982827486");
        user.setPassword("admin");
        user.setRole(Role.ADMIN);

        userService.saveUser(user);
    }

    @GetMapping("/subjects/{id}")
    public List<SubjectDto> getGroupSubjects(@PathVariable("id") Long id){
        return subjectService.findSubjectsByGroupId(id);
    }

    @GetMapping("/teachers/{id}")
    public List<TeacherDto> getGroupTeachers(@PathVariable("id") Long id){
        return teacherService.findTeacherByGroupId(id);
    }
}
