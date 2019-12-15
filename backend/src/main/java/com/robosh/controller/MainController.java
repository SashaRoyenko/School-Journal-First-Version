package com.robosh.controller;

import com.robosh.data.dto.SubjectDto;
import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.User;
import com.robosh.data.enumeration.Role;
import com.robosh.service.StudentService;
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
    private StudentService studentService;

    @Autowired
    public MainController(UserService userService, SubjectService subjectService, TeacherService teacherService, StudentService studentService) {
        this.userService = userService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }


    @GetMapping("/")
    public String getMain() {
        return SecurityContextHolder.getContext().getAuthentication().toString();
    }

    @PostMapping("/user/save")
    public void saveUser() {
        final String ADMIN_NAME = "Admin";
        User user = new User();
        user.setFirstName(ADMIN_NAME);
        user.setSecondName(ADMIN_NAME);
        user.setLastName(ADMIN_NAME);
        user.setEmail("admin@admin.com");
        user.setPhone("+380982827486");
        user.setPassword("admin");
        user.setRole(Role.ADMIN);

        userService.saveUser(user);
    }

    @PostMapping("/init")
    public void initDb() {
        initAdmins();
    }

    private void initAdmins() {
        User admin1 = new User();
        admin1.setFirstName("Орест");
        admin1.setSecondName("Андрійович");
        admin1.setLastName("Шемелюк");
        admin1.setEmail("orest_shemelyuk@gmail.com");
        admin1.setPhone("+380552827486");
        admin1.setPassword("admin1");
        admin1.setRole(Role.ADMIN);

        User admin2 = new User();
        admin2.setFirstName("Олександр");
        admin2.setSecondName("Олегович");
        admin2.setLastName("Роєнко");
        admin2.setEmail("oleks_roienko@gmail.com");
        admin2.setPhone("+380222827486");
        admin2.setPassword("admin2");
        admin2.setRole(Role.ADMIN);

        User admin3 = new User();
        admin3.setFirstName("Констянтин");
        admin3.setSecondName("Миколайович");
        admin3.setLastName("Сторожук");
        admin3.setEmail("kostia_stotozhuk@gmail.com");
        admin3.setPhone("+380112827486");
        admin3.setPassword("admin3");
        admin3.setRole(Role.ADMIN);

        User admin4 = new User();
        admin4.setFirstName("Нікіта");
        admin4.setSecondName("Васильович");
        admin4.setLastName("Бортнічук");
        admin4.setEmail("nikita_bortnichuk@gmail.com");
        admin4.setPhone("+380992827486");
        admin4.setPassword("admin4");
        admin4.setRole(Role.ADMIN);

        userService.saveUser(admin1);
        userService.saveUser(admin2);
        userService.saveUser(admin3);
        userService.saveUser(admin4);
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
