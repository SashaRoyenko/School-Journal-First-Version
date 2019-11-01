package com.robosh.controller;

import com.robosh.data.dto.*;
import com.robosh.data.mapping.UserMapper;
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
    private UserMapper userMapper;
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

    @PatchMapping("/teacher/{id}")
    public TeacherDto updateTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        return teacherService.save(teacherDto);
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable(value = "id") Long id) {
        return userService.delete(id);
    }

    @PostMapping("/student")
    public void saveStudent(@RequestBody StudentDto studentDto) {
    }

    @PatchMapping("/student/{id}")
    public void updateStudent(@RequestBody StudentDto studentDto) {
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@RequestBody StudentDto studentDto) {
    }

    @PostMapping("/parent")
    public void saveParent(@RequestBody ParentDto parentDto) {
    }

    @PatchMapping("/parent/{id}")
    public void updateParent(@RequestBody ParentDto parentDto) {
    }

    @DeleteMapping("/parent/{id}")
    public void deleteParent(@RequestBody ParentDto parentDto) {
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveAdmin(@RequestBody UserDto user) {
        return userService.save(userMapper.dtoToUser(user));
    }

    // todo find right variant of update
    @PatchMapping("/{id}")
    public UserDto updateAdmin(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long id) {
        return userService.delete(id);
    }

    @PostMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public GroupDto saveGroup(@Valid @RequestBody GroupDto groupDto) {
        return groupService.save(groupDto);
    }

    @GetMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public List<GroupDto> getGroups() {
        return groupService.findAll();
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value = "id") Long id) {
        return groupService.delete(id);
    }

    @PostMapping("/subject")
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectDto saveSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.save(subjectDto);
    }

    @GetMapping("/subject")
    @ResponseStatus(HttpStatus.CREATED)
    public List<SubjectDto> getSubject() {
        return subjectService.findAll();
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable(value = "id") Long id) {
        return subjectService.delete(id);
    }

    @PostMapping("/schedule")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ScheduleDto> saveSchedule(@Valid @RequestBody List<ScheduleDto> scheduleDto) {
        return scheduleService.save(scheduleDto);
    }

    @GetMapping("/schedule/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ScheduleDto> getSchedule(@PathVariable Long id) {
        return scheduleService.findByGroup(id);
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<?> deleteSchedule(@PathVariable(value = "id") Long id) {
        return scheduleService.delete(id);
    }

}
