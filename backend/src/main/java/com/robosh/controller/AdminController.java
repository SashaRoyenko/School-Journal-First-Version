package com.robosh.controller;

import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Teacher;
import com.robosh.data.repository.TeacherRepository;
import com.robosh.data.repository.UserRepository;
import com.robosh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.robosh.common_routes.Routes.ADMIN_MAPPING;
import static com.robosh.common_routes.Routes.REDIRECT_URL;

@Controller
@RequestMapping(ADMIN_MAPPING)
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private static final String TEACHERS_MAPPING = "/teachers";

    private final TeacherService teacherService;

    @Autowired
    public AdminController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = {"", TEACHERS_MAPPING})
    public String getAllTeachers(Model model){
        List<TeacherDto> teachers = teacherService.findAll();
        model.addAttribute("teacherList", teachers);

        return "admin/teachers";
    }

    @GetMapping(value = {TEACHERS_MAPPING + "/edit", TEACHERS_MAPPING + "/edit/{id}"})
    public String editTeacherById(Model model, @PathVariable("id") Optional<Long> id){
        if(id.isPresent()){
            TeacherDto teacher = teacherService.findById(id.get());
            model.addAttribute("teacher", teacher);
        }
        else {
            model.addAttribute("teacher", new TeacherDto());
        }
        return "admin/add_teacher";
    }


    @PostMapping(value = TEACHERS_MAPPING + "/add")
    public String createOrUpdate(TeacherDto teacherDto){
        if (teacherDto.getId()==null){
            teacherService.save(teacherDto);
        }
        else {
            teacherService.update(teacherDto);
        }

        return REDIRECT_URL + ADMIN_MAPPING + TEACHERS_MAPPING;
    }

}
