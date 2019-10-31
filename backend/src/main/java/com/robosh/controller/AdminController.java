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
    private UserMapper userMapper;

    @Autowired
    public AdminController(UserService userService, TeacherService teacherService, ParentService parentService, StudentService studentService, GroupService groupService) {
        this.userService = userService;
        this.teacherService = teacherService;
        this.parentService = parentService;
        this.studentService = studentService;
        this.groupService = groupService;
    }

    //todo create teacher/user/parent/student mapper and repositories
    @PostMapping("/teacher")
    public void saveTeacher(@RequestBody TeacherDto user) {
    }

    @PatchMapping("/teacher/{id}")
    public void updateTeacher(@RequestBody TeacherDto user) {
    }

    @DeleteMapping("/teacher/{id}")
    public void deleteTeacher(@RequestBody TeacherDto user) {
    }

    @PostMapping("/student")
    public void saveStudent(@RequestBody StudentDto user) {
    }

    @PatchMapping("/student/{id}")
    public void updateStudent(@RequestBody StudentDto user) {
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@RequestBody StudentDto user) {
    }

    @PostMapping("/parent")
    public void saveParent(@RequestBody ParentDto user) {
    }

    @PatchMapping("/parent/{id}")
    public void updateParent(@RequestBody ParentDto user) {
    }

    @DeleteMapping("/parent/{id}")
    public void deleteParent(@RequestBody ParentDto user) {
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
    public GroupDto saveGroup(@Valid @RequestBody GroupDto groupDto){
        return groupService.save(groupDto);
    }

    @GetMapping("/group")
    @ResponseStatus(HttpStatus.CREATED)
    public List<GroupDto> getGroups(){
        return groupService.findAll();
    }

    @DeleteMapping("/group/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable(value = "id") Long id){
        return groupService.delete(id);
    }

}
