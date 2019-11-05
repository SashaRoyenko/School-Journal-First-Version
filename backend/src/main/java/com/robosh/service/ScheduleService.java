package com.robosh.service;

import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.dto.SubjectDto;
import com.robosh.data.entity.Group;
import com.robosh.data.mapping.GroupMapper;
import com.robosh.data.mapping.ScheduleMapper;
import com.robosh.data.repository.ScheduleRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;
    private ScheduleMapper scheduleMapper = ScheduleMapper.INSTANCE;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
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

    public ResponseEntity<?> delete(Long id) {
        scheduleRepository.delete(scheduleMapper.dtoToSchedule(findById(id)));
        return ResponseEntity.ok().build();
    }

}
