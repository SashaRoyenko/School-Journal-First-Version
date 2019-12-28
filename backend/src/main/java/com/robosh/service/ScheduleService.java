package com.robosh.service;

import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.entity.Group;
import com.robosh.data.entity.Schedule;
import com.robosh.data.entity.Subject;
import com.robosh.data.mapping.ScheduleMapper;
import com.robosh.data.repository.ScheduleRepository;
import com.robosh.exception.ResourceNotFoundException;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ScheduleDto> findByGroupId(Long id) {
        return scheduleMapper.schedulesToDto(scheduleRepository.findByGroupId(id));
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
}
