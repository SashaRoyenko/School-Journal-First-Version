package com.robosh.controller;

import com.robosh.data.dto.HomeworkDto;
import com.robosh.data.dto.ScheduleDto;
import com.robosh.service.HomeworkService;
import com.robosh.service.ScheduleService;
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

    @Autowired
    public StudentController(HomeworkService homeworkService, ScheduleService scheduleService) {
        this.homeworkService = homeworkService;
        this.scheduleService = scheduleService;
    }

//    @GetMapping("/marks")
//    public MarksDto getMarks(){
//
//    }

    @GetMapping("/{studentId}/subject/{subjectId}/homework")
    public List<HomeworkDto> getHomework(@PathVariable Long studentId, @PathVariable Long subjectId) {
        return homeworkService.findByUserIdAndSubjectId(studentId, subjectId);
    }

    @GetMapping("schedule/group/{Id}")
    public List<ScheduleDto> getSchedule(@PathVariable Long id) {
        return scheduleService.findByGroupId(id);
    }

}
