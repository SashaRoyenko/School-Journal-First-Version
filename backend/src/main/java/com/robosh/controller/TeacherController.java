package com.robosh.controller;

import com.robosh.data.dto.*;
import com.robosh.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;
    private SubjectService subjectService;
    private GroupService groupService;
    private StudentService studentService;
    private HomeworkService homeworkService;

    @Autowired
    public TeacherController(TeacherService teacherService, SubjectService subjectService, GroupService groupService, StudentService studentService, HomeworkService homeworkService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.groupService = groupService;
        this.studentService = studentService;
        this.homeworkService = homeworkService;
    }

    @GetMapping("/{id}/subjects")
    public List<SubjectDto> getTeacherSubjects(@PathVariable("id") Long id) {
        return subjectService.findSubjectByTeacherId(id);
    }

    @GetMapping("/{id}/groups")
    public List<GroupDto> getTeacherGroups(@PathVariable("id") Long id) {
        return groupService.findGroupByTeacherId(id);
    }

    @GetMapping("/groups/group/{id}/students")
    public List<StudentDto> getGroupStudents(@PathVariable("id") Long id) {
        return studentService.findStudentByGroupId(id);
    }


    @GetMapping("/{teacherId}/groups/group/{groupId}")
    public List<SubjectDto> getTeacherSubjectsByGroup(@PathVariable("teacherId") Long teacherId, @PathVariable("groupId") Long groupId) {
        return subjectService.findSubjectByTeacherIdAndGroupId(teacherId, groupId);
    }

    @PostMapping("/homework")
    public HomeworkDto createHomework(@RequestBody HomeworkDto homeworkDto) {
        return homeworkService.save(homeworkDto);
    }

    @GetMapping("/homework/{id}")
    public HomeworkDto getHomeworkById(@PathVariable("id") Long id) {
        return homeworkService.findById(id);
    }

    @GetMapping("/homework/group/{id}")
    public List<HomeworkDto> getGroupHomework(@PathVariable("id") Long id) {
        return homeworkService.findByGroupId(id);
    }

    @GetMapping("/homework/teacher/{id}")
    public List<HomeworkDto> getTeacherHomework(@PathVariable("id") Long id) {
        return homeworkService.findByTeacherId(id);
    }

    @PutMapping("/")
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto)
    {
        return teacherService.update(teacherDto);
    }
}
