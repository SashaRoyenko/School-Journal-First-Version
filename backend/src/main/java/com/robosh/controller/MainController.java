package com.robosh.controller;

import com.robosh.data.dto.SubjectDto;
import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.*;
import com.robosh.data.enumeration.Role;
import com.robosh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RestController
public class MainController {
    private UserService userService;
    private SubjectService subjectService;
    private TeacherService teacherService;
    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    public MainController(UserService userService, SubjectService subjectService, TeacherService teacherService, StudentService studentService, GroupService groupService) {
        this.userService = userService;
        this.subjectService = subjectService;
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.groupService = groupService;
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
        initGroups();
        initTeachers();
        initStudents();
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

    private void initGroups() {
        Group group1 = new Group();
        group1.setGroupCode("1-А");
        Group group2 = new Group();
        group2.setGroupCode("1-Б");
        Group group3 = new Group();
        group3.setGroupCode("2-А");
        Group group4 = new Group();
        group4.setGroupCode("2-Б");
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        groupService.saveGroup(group3);
        groupService.saveGroup(group4);
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

    private void initStudents() {
        Group group1 = groupService.convertGroupDtoToEntity(groupService.findByCodeGroup("1-А"));
        Student student1 = Student.builder()
                .firstName("Катерина")
                .secondName("Олегівна")
                .lastName("Антонюк")
                .email("katerina_antoniuk@gmai.com")
                .password("password12")
                .phone("+380974444444")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.JANUARY, 11))
                .address("Васильківська 12")
                .group(group1)
                .build();

        Student student2 = Student.builder()
                .firstName("Юлія")
                .secondName("Петрівна")
                .lastName("Бондаренко")
                .email("__585T_@gmai.com")
                .password("password1")
                .phone("+380937569845")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.MARCH, 14))
                .address("Магістральна 2")
                .group(group1)
                .build();

        Student student3 = Student.builder()
                .firstName("Яна")
                .secondName("Олегівна")
                .lastName("Верстлер")
                .email("gK137Dg@gmai.com")
                .password("password1")
                .phone("+380924219864")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.JANUARY, 3))
                .address("Магнітогорська 12")
                .group(group1)
                .build();

        Student student4 = Student.builder()
                .firstName("Юрій")
                .secondName("Андрійович")
                .lastName("Висоцький")
                .email("gK137Dgss@gmai.com")
                .password("password12")
                .phone("+380939589649")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2002, Calendar.JANUARY, 17))
                .address("Магнітогорський 5")
                .group(group1)
                .build();

        Student student5 = Student.builder()
                .firstName("Анна")
                .secondName("Петрівна")
                .lastName("Гнап")
                .email("dsaasdsaddsa@gmai.com")
                .password("password12")
                .phone("+380917852599")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2002, Calendar.MAY, 3))
                .address("Маяковського 5")
                .group(group1)
                .build();

        Student student6 = Student.builder()
                .firstName("Олексій")
                .secondName("Валерійович")
                .lastName("Грицюк")
                .email("sadsadsada@gmai.com")
                .password("password12")
                .phone("+380941034728")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.NOVEMBER, 6))
                .address("Маяковського 88")
                .group(group1)
                .build();

        Student student7 = Student.builder()
                .firstName("Денис")
                .secondName("Петрович")
                .lastName("Горваль")
                .email("sadsadsadasas@gmai.com")
                .password("password12")
                .phone("+380902160537")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.SEPTEMBER, 24))
                .address("Васильківська 43")
                .group(group1)
                .build();

        Student student8 = Student.builder()
                .firstName("Валентин")
                .secondName("Олексондрович")
                .lastName("Герасимович")
                .email("assadsadgfdgew@gmai.com")
                .password("password12")
                .phone("+380959801128")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.MAY, 5))
                .address("Калинова 12")
                .group(group1)
                .build();

        Student student9 = Student.builder()
                .firstName("Микита")
                .secondName("Олегович")
                .lastName("Балєєв")
                .email("ssssnghgngbvtoniuk@gmai.com")
                .password("password12")
                .phone("+380964319388")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2003, Calendar.MARCH, 5))
                .address("Калинова 67")
                .group(group1)
                .build();

        Student student10 = Student.builder()
                .firstName("Павло")
                .secondName("Васильович")
                .lastName("Артемюк")
                .email("asdasfsdaaa@gmai.com")
                .password("password12")
                .phone("+380965540202")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.JANUARY, 7))
                .address("Кам'янська 6")
                .group(group1)
                .build();

        Group group2 = groupService.convertGroupDtoToEntity(groupService.findByCodeGroup("2-А"));

        Student student11 = Student.builder()
                .firstName("Марія")
                .secondName("Олегівна")
                .lastName("Якимчук")
                .email("sadasfsdvxzcx@gmai.com")
                .password("password12")
                .phone("+380971821467")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.MARCH, 2))
                .address("Карельський 3")
                .group(group2)
                .build();

        Student student12 = Student.builder()
                .firstName("Ірина")
                .secondName("Андріїна")
                .lastName("Якобчук")
                .email("sadasdcxzc@gmai.com")
                .password("password12")
                .phone("+380926749639")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2005, Calendar.FEBRUARY, 1))
                .address("Карельський 55")
                .group(group2)
                .build();

        Student student13 = Student.builder()
                .firstName("Віталій")
                .secondName("Ігорович")
                .lastName("Яворський")
                .email("sadvfdtresdfcz@gmai.com")
                .password("password12")
                .phone("+380931215534")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2005, Calendar.FEBRUARY, 12))
                .address("Квітуча 32")
                .group(group2)
                .build();

        Student student14 = Student.builder()
                .firstName("Анна")
                .secondName("Олександрівна")
                .lastName("Шишкіна")
                .email("asdcvtrsdcv@gmai.com")
                .password("password12")
                .phone("+380904781821")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.SEPTEMBER, 11))
                .address("Квітуча 77")
                .group(group2)
                .build();

        Student student15 = Student.builder()
                .firstName("Ірина")
                .secondName("Олегівна")
                .lastName("Роспопа")
                .email("bgfdfvcbn@gmai.com")
                .password("password12")
                .phone("+380999688307")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.MARCH, 24))
                .address("Кирилівська 76")
                .group(group2)
                .build();

        Student student16 = Student.builder()
                .firstName("Ірина")
                .secondName("Валерівна")
                .lastName("Хилю")
                .email("sadfghtrdgfd@gmai.com")
                .password("password12")
                .phone("+380989844978")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.DECEMBER, 27))
                .address("Кирилівська 33")
                .group(group2)
                .build();

        Student student17 = Student.builder()
                .firstName("Оксана")
                .secondName("Остапівна")
                .lastName("Степура")
                .email("vbgfmkjlhj@gmai.com")
                .password("password12")
                .phone("+380988486456")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.NOVEMBER, 11))
                .address("Коновала Пилипа 12")
                .group(group2)
                .build();

        Student student18 = Student.builder()
                .firstName("Микола")
                .secondName("Назарович")
                .lastName("Спасовка")
                .email("sdgfhjkhgfcx@gmai.com")
                .password("password12")
                .phone("+380938853830")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.FEBRUARY, 4))
                .address("Коновала Пилипа 33")
                .group(group2)
                .build();

        Student student19 = Student.builder()
                .firstName("Юлія")
                .secondName("Олександрівна")
                .lastName("Остапчук")
                .email("fbghjkjhbvcx@gmai.com")
                .password("password12")
                .phone("+380904702956")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2005, Calendar.NOVEMBER, 1))
                .address("Саксаганського 12")
                .group(group2)
                .build();

        Student student20 = Student.builder()
                .firstName("Владислав")
                .secondName("Петрович")
                .lastName("Недзельський")
                .email("safgnhjytdrfsz@gmai.com")
                .password("password12")
                .phone("+380974848514")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.DECEMBER, 22))
                .address("Саксаганського 44")
                .group(group2)
                .build();

        Student student21 = Student.builder()
                .firstName("Катерина")
                .secondName("Олегівна")
                .lastName("Лущик")
                .email("safvbgfdgfx@gmai.com")
                .password("password12")
                .phone("+380914163089")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2005, Calendar.FEBRUARY, 6))
                .address("Саксаганського 76")
                .group(group2)
                .build();

        Student student22 = Student.builder()
                .firstName("Наталія")
                .secondName("Юрівна")
                .lastName("Копернік")
                .email("sfgjthdf@gmai.com")
                .password("password12")
                .phone("+380983900546")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.JUNE, 3))
                .address("Салютний 65")
                .group(group2)
                .build();

        Student student23 = Student.builder()
                .firstName("Віринея")
                .secondName("Петрівна")
                .lastName("Князь")
                .email("sdsadasfsd@gmai.com")
                .password("password12")
                .phone("+380918787919")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.SEPTEMBER, 9))
                .address("Мазепи Івана 7")
                .group(group2)
                .build();

        Student student24 = Student.builder()
                .firstName("Вікторія")
                .secondName("Василівна")
                .lastName("Жданюк")
                .email("gggggfffff@gmai.com")
                .password("password12")
                .phone("+380989917163")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.MAY, 8))
                .address("Мазепи Івана 65")
                .group(group2)
                .build();

        Student student25 = Student.builder()
                .firstName("Олександра")
                .secondName("Андріївна")
                .lastName("Діденко")
                .email("gfhgfdsasd@gmai.com")
                .password("password12")
                .phone("+380993631899")
                .role(Role.STUDENT)
                .active(true)
                .birthDate(new Date(2004, Calendar.JULY, 7))
                .address("Мазепи Івана 12")
                .group(group2)
                .build();
        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        studentService.saveStudent(student3);
        studentService.saveStudent(student4);
        studentService.saveStudent(student5);
        studentService.saveStudent(student6);
        studentService.saveStudent(student7);
        studentService.saveStudent(student8);
        studentService.saveStudent(student9);
        studentService.saveStudent(student10);
        studentService.saveStudent(student11);
        studentService.saveStudent(student12);
        studentService.saveStudent(student13);
        studentService.saveStudent(student14);
        studentService.saveStudent(student15);
        studentService.saveStudent(student16);
        studentService.saveStudent(student17);
        studentService.saveStudent(student18);
        studentService.saveStudent(student19);
        studentService.saveStudent(student20);
        studentService.saveStudent(student21);
        studentService.saveStudent(student22);
        studentService.saveStudent(student23);
        studentService.saveStudent(student24);
        studentService.saveStudent(student25);
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
