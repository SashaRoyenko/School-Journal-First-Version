package com.robosh.controller;

import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.dto.SubjectDto;
import com.robosh.service.HomeworkService;
import com.robosh.service.ScheduleService;
import com.robosh.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private HomeworkService homeworkService;
    private ScheduleService scheduleService;
    private SubjectService subjectService;

    @Autowired
    public StudentController(HomeworkService homeworkService, ScheduleService scheduleService, SubjectService subjectService) {
        this.homeworkService = homeworkService;
        this.scheduleService = scheduleService;
        this.subjectService = subjectService;
    }

//    @GetMapping("/marks")
//    public MarksDto getMarks(){
//
//    }

    @GetMapping("group/{groupId}/subject/{subjectId}/homework")
    public List<HomeworkDto> getHomework(@PathVariable("studentId") Long groupId, @PathVariable("subjectId") Long subjectId) {
        return homeworkService.findByGroupIdAndSubjectId(groupId, subjectId);
    }

    @GetMapping("schedule/group/{id}")
    public List<ScheduleDto> getSchedule(@PathVariable Long id) {
        return scheduleService.findByGroupId(id);
    }

    @GetMapping("/group/{id}/subject")
    public List<SubjectDto> getStudentSubjects(@PathVariable("id") Long id){
        return subjectService.findSubjectsByGroupId(id);
    }

}
