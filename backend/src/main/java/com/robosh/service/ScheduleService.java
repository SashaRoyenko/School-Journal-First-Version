package com.robosh.service;

import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Schedule;
import com.robosh.data.entity.Subject;
import com.robosh.data.mapping.ScheduleMapper;
import com.robosh.data.repository.ScheduleRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private ScheduleMapper scheduleMapper = ScheduleMapper.INSTANCE;
    private ModelMapper modelMapper;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }

    public ScheduleDto save(ScheduleDto scheduleDto) {
        return scheduleMapper.scheduleToDto(scheduleRepository.save(scheduleMapper.dtoToSchedule(scheduleDto)));
    }

    public List<ScheduleDto> save(List<ScheduleDto> scheduleDto) {
        return scheduleMapper.schedulesToDto(scheduleRepository.saveAll(scheduleMapper.dtoToSchedules(scheduleDto)));
    }

    public List<Schedule> findByGroupId(Long id) {
        return scheduleRepository.findByGroupId(id);
    }

    public ScheduleDto findById(Long id) {
        return scheduleMapper.scheduleToDto(
                scheduleRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("Schedule", "id", id)
                )
        );
    }

    public ResponseEntity delete(Long id) {
        scheduleRepository.delete(scheduleMapper.dtoToSchedule(findById(id)));
        return ResponseEntity.ok().build();
    }

    public ScheduleDto update(ScheduleDto scheduleDto) {
        Schedule updatedSchedule = scheduleMapper.dtoToSchedule(scheduleDto);
        Schedule currentSchedule = scheduleMapper.dtoToSchedule(findById(updatedSchedule.getId()));
        modelMapper.map(updatedSchedule, currentSchedule);
        return scheduleMapper.scheduleToDto(scheduleRepository.save(currentSchedule));
    }

    public List<Subject> getSubjectsByTeacherId(Long id) {
        List<Schedule> scheduleList = scheduleRepository.findScheduleByTeacherId(id);
        List<Subject> subjects = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            subjects.add(schedule.getSubject());
        }
        return subjects;
    }

    public List<Group> getGroupsByTeacherId(Long id) {
        List<Schedule> scheduleList = scheduleRepository.findScheduleByTeacherId(id);
        List<Group> groups = new ArrayList<>();
        for (Schedule schedule : scheduleList) {
            groups.add(schedule.getGroup());
        }
        return groups;
    }

    public List<Schedule> getScheduleByTeacherId(Long id) {
        return scheduleRepository.findScheduleByTeacherId(id);
    }

    public Map<DayOfWeek, List<Schedule>> getScheduleForEachDay(List<Schedule> schedules) {
        return schedules.stream()
                .collect(Collectors.groupingBy(Schedule::getDayOfWeek));
    }

    public List<Schedule> findAll(){
        return scheduleRepository.findAll();
    }

    public Map<Integer, List<Schedule>> getIntegerSchedule(Map<DayOfWeek, List<Schedule>> map) {

        Map<Integer, List<Schedule>> listMap = new HashMap<>();
        Set<DayOfWeek> dayOfWeeks = map.keySet();

        if (dayOfWeeks.contains(DayOfWeek.MONDAY)) {
            listMap.put(1, map.get(DayOfWeek.MONDAY));
        }
        if (dayOfWeeks.contains(DayOfWeek.TUESDAY)) {
            listMap.put(2, map.get(DayOfWeek.TUESDAY));
        }
        if (dayOfWeeks.contains(DayOfWeek.WEDNESDAY)) {
            listMap.put(3, map.get(DayOfWeek.WEDNESDAY));
        }
        if (dayOfWeeks.contains(DayOfWeek.THURSDAY)) {
            listMap.put(4, map.get(DayOfWeek.THURSDAY));
        }
        if (dayOfWeeks.contains(DayOfWeek.FRIDAY)) {
            listMap.put(5, map.get(DayOfWeek.FRIDAY));
        }

        return listMap;

    }
}
