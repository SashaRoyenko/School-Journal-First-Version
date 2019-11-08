package com.robosh.controller;

import com.robosh.data.dto.GroupDto;
import com.robosh.data.dto.StudentDto;
import com.robosh.data.dto.SubjectDto;
import com.robosh.service.GroupService;
import com.robosh.service.StudentService;
import com.robosh.service.SubjectService;
import com.robosh.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private TeacherService teacherService;
    private SubjectService subjectService;
    private GroupService groupService;
    private StudentService studentService;

    @Autowired
    public TeacherController(TeacherService teacherService, SubjectService subjectService, GroupService groupService, StudentService studentService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("/{id}/subjects")
    public List<SubjectDto> getTeacherSubjects(@PathVariable("id") Long id) {
        return subjectService.findSubjectByTeacherId(id);
    }

    @GetMapping("/{id}/groups")
    public List<GroupDto> getTeacherGroups(@PathVariable("id") Long id) {
        return groupService.findGroupByTeacherId(id);
    }

//    @GetMapping("/groups/group/{id}/students")
//    public List<StudentDto> getGroupStudents(@PathVariable("id") Long id){
//        return studentService.findStudentByGroupId(id);
//    }


    @GetMapping("/{teacherId}/groups/group/{groupId}")
    public List<SubjectDto> getTeacherSubjectsByGroup(@PathVariable("teacherId") Long teacherId, @PathVariable("groupId") Long groupId) {
        return subjectService.findSubjectByTeacherIdAndGroupId(teacherId, groupId);
    }


}
