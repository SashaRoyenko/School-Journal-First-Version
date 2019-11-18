package com.robosh.controller;

import com.robosh.data.dto.*;
import com.robosh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private TeacherService teacherService;
    private ParentService parentService;
    private StudentService studentService;
    private GroupService groupService;
    private SubjectService subjectService;
    private ScheduleService scheduleService;

    @Autowired
    public AdminController(UserService userService, TeacherService teacherService, ParentService parentService, StudentService studentService, GroupService groupService, SubjectService subjectService, ScheduleService scheduleService) {
        this.userService = userService;
        this.teacherService = teacherService;
        this.parentService = parentService;
        this.studentService = studentService;
        this.groupService = groupService;
        this.subjectService = subjectService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/teacher")
    public List<TeacherDto> getTeachers() {
        return teacherService.findAll();
    }

    @PostMapping("/teacher")
    public TeacherDto saveTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

    @PutMapping("/teacher")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.update(teacherDto);
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity deleteTeacher(@PathVariable(value = "id") Long id) {
        return userService.delete(id);
    }

    @GetMapping("/student")
    public List<StudentDto> getStudents() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public StudentDto getStudent(@PathVariable("id") Long id) {
        return studentService.findByStudentId(id);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto saveStudent(@Valid @RequestBody StudentDto studentDto) {
        return studentService.save(studentDto);
    }

    @PutMapping("/student")
    public void updateStudent(@RequestBody StudentDto studentDto) {
        studentService.update(studentDto);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Long id) {
        return studentService.delete(id);
    }

    @GetMapping("/parent/{id}")
    public ParentDto getParent(@PathVariable(value = "id") Long id) {
        return parentService.findByParentId(id);
    }

    @GetMapping("/parent")
    public List<ParentDto> getParents() {
        return parentService.findAll();
    }

    @PostMapping("/parent")
    @ResponseStatus(HttpStatus.CREATED)
    public ParentDto saveParent(@Valid @RequestBody ParentDto parentDto) {
        return parentService.save(parentDto);
    }

    @PutMapping("/parent")
    public void updateParent(@RequestBody ParentDto parentDto) {
        parentService.update(parentDto);
    }

    @DeleteMapping("/parent/{id}")
    public ResponseEntity deleteParent(@PathVariable(value = "id") Long id) {
        return parentService.delete(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveAdmin(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/")
    public UserDto updateAdmin(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable(value = "id") Long id) {
        return userService.delete(id);
    }

    @PostMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDto saveGroup(@Valid @RequestBody GroupDto groupDto) {
        return groupService.save(groupDto);
    }

    @GetMapping("/group")
    public List<GroupDto> getGroups() {
        return groupService.findAll();
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity deleteGroup(@PathVariable(value = "id") Long id) {
        return groupService.delete(id);
    }

    @PostMapping("/subject")
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectDto saveSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.save(subjectDto);
    }

    @GetMapping("/subject")
    public List<SubjectDto> getSubject() {
        return subjectService.findAll();
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity deleteSubject(@PathVariable(value = "id") Long id) {
        return subjectService.delete(id);
    }

    @PostMapping("/schedule")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ScheduleDto> saveSchedule(@Valid @RequestBody List<ScheduleDto> scheduleDto) {
        return scheduleService.save(scheduleDto);
    }

    @GetMapping("/schedule/{id}")
    public List<ScheduleDto> getSchedule(@PathVariable Long id) {
        return scheduleService.findByGroupId(id);
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity deleteSchedule(@PathVariable(value = "id") Long id) {
        return scheduleService.delete(id);
    }

    @PutMapping("/schedule")
    public ScheduleDto updateSchedule(@RequestBody ScheduleDto scheduleDto) {
        return scheduleService.update(scheduleDto);
    }

}
