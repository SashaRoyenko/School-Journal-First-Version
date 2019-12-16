package com.robosh.controller;

import com.robosh.data.dto.SubjectDto;
import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Subject;
import com.robosh.data.entity.Teacher;
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
        initSubjects();
        initTeachers();
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

    private void initSubjects() {
        Subject subject1 = new Subject();
        subject1.setName("Українська мова");
        Subject subject2 = new Subject();
        subject2.setName("Англійська мова");
        Subject subject3 = new Subject();
        subject3.setName("Російська мова");
        Subject subject4 = new Subject();
        subject4.setName("Математика");
        Subject subject5 = new Subject();
        subject5.setName("Алгебра");
        Subject subject6 = new Subject();
        subject6.setName("Геометрія");
        Subject subject7 = new Subject();
        subject7.setName("Фізика");
        Subject subject8 = new Subject();
        subject8.setName("Біологія");
        Subject subject9 = new Subject();
        subject9.setName("Хімія");
        Subject subject10 = new Subject();
        subject10.setName("Фізкультура");
        Subject subject11 = new Subject();
        subject11.setName("Трудове навчання");
        subjectService.saveSubject(subject1);
        subjectService.saveSubject(subject2);
        subjectService.saveSubject(subject3);
        subjectService.saveSubject(subject4);
        subjectService.saveSubject(subject5);
        subjectService.saveSubject(subject6);
        subjectService.saveSubject(subject7);
        subjectService.saveSubject(subject8);
        subjectService.saveSubject(subject9);
        subjectService.saveSubject(subject10);
        subjectService.saveSubject(subject11);
    }

    private void initTeachers() {
        Teacher teacher1 = Teacher.builder()
                .firstName("Божена")
                .secondName("Романівна")
                .lastName("Коваль")
                .phone("+380981827486")
                .email("bozhena_koval@teacher.com")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Пушкіна 12")
                .active(true)
                .build();

        Teacher teacher2 = Teacher.builder()
                .firstName("Ірина")
                .secondName("Борисівна")
                .lastName("Годя")
                .email("godia_ira@admin.com")
                .phone("+380981867486")
                .password("teacher2")
                .role(Role.TEACHER)
                .address("Василя 4")
                .active(true)
                .build();

        Teacher teacher3 = Teacher.builder()
                .firstName("Іван")
                .secondName("Михайлович")
                .lastName("Штаба")
                .email("shtab_ivan@gmail.com")
                .phone("+380981829486")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Зелеого 17А")
                .active(true)
                .build();

        Teacher teacher4 = Teacher.builder()
                .firstName("Олеся")
                .secondName("Миколаївна")
                .lastName("Мохнач")
                .email("mochach_lesia@gmail.com")
                .phone("+380988827486")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Петриківська 4")
                .active(true)
                .build();

        Teacher teacher5 = Teacher.builder()
                .firstName("Наталя")
                .secondName("Василівна")
                .lastName("Бачук")
                .email("bachuk_vas@gmail.com")
                .phone("+380981827446")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Пушкіна 44")
                .active(true)
                .build();

        Teacher teacher6 = Teacher.builder()
                .firstName("Надія")
                .secondName("Іванівна")
                .lastName("Ренська")
                .email("renskaya@gmail.com")
                .phone("+380981807486")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Хмельницька 7")
                .active(true)
                .build();

        Teacher teacher7 = Teacher.builder()
                .firstName("Алла")
                .secondName("Борисівна")
                .lastName("Лесик")
                .email("borysivna@admin.com")
                .phone("+380981827996")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Пушкіна 55")
                .active(true)
                .build();

        Teacher teacher8 = Teacher.builder()
                .firstName("Андрій")
                .secondName("Миколайович")
                .lastName("Дереновський")
                .email("derenovkiy@gmail.com")
                .phone("+380981821186")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Пушкіна 8")
                .active(true)
                .build();

        Teacher teacher9 = Teacher.builder()
                .firstName("Алла")
                .secondName("Олександрівна")
                .lastName("Іщенко")
                .email("ishchenko@gmail.com")
                .phone("+380981827998")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Петриківска 12")
                .active(true)
                .build();

        Teacher teacher10 = Teacher.builder()
                .firstName("Лариса")
                .secondName("Миколаївна")
                .lastName("Вельгас")
                .email("velgas@gmail.com")
                .phone("+380981777486")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Юзькова 46")
                .active(true)
                .build();

        Teacher teacher11 = Teacher.builder()
                .firstName("Катерина")
                .secondName("Василівна")
                .lastName("Ковтун")
                .email("kovtun__@gmail.com")
                .phone("+380981667486")
                .password("teacher1")
                .role(Role.TEACHER)
                .address("Павлівська 89")
                .active(true)
                .build();
        teacherService.saveTeacher(teacher1);
        teacherService.saveTeacher(teacher2);
        teacherService.saveTeacher(teacher3);
        teacherService.saveTeacher(teacher4);
        teacherService.saveTeacher(teacher5);
        teacherService.saveTeacher(teacher6);
        teacherService.saveTeacher(teacher7);
        teacherService.saveTeacher(teacher8);
        teacherService.saveTeacher(teacher9);
        teacherService.saveTeacher(teacher10);
        teacherService.saveTeacher(teacher11);
    }

    @GetMapping("/subjects/{id}")
    public List<SubjectDto> getGroupSubjects(@PathVariable("id") Long id) {
        return subjectService.findSubjectsByGroupId(id);
    }

    @GetMapping("/teachers/{id}")
    public List<TeacherDto> getGroupTeachers(@PathVariable("id") Long id) {
        return teacherService.findTeacherByGroupId(id);
    }
}
