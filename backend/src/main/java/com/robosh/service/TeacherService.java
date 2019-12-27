package com.robosh.service;

import com.robosh.data.dto.TeacherDto;
import com.robosh.data.entity.Teacher;
import com.robosh.data.entity.User;
import com.robosh.data.mapping.TeacherMapper;
import com.robosh.data.repository.ScheduleRepository;
import com.robosh.data.repository.TeacherRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository teacherRepository;
    private ScheduleRepository scheduleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private TeacherMapper teacherMapper;
    private ModelMapper modelMapper;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository, ScheduleRepository scheduleRepository, BCryptPasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.teacherRepository = teacherRepository;
        this.scheduleRepository = scheduleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        teacherMapper = TeacherMapper.INSTANCE;
    }

    public Teacher saveTeacher(Teacher teacher) {
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        return teacherRepository.save(teacher);
    }

    public TeacherDto save(TeacherDto teacherDto) {
        teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
        return teacherMapper.teacherToDto(teacherRepository.save(teacherMapper.dtoToTeacher(teacherDto)));
    }

    public List<TeacherDto> findAll() {
        return teacherMapper.teachersToDto(teacherRepository.findAll());
    }

    public TeacherDto findById(Long id) {
        return teacherMapper.teacherToDto(teacherRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Teacher", "id", id)
        ));
    }

    public ResponseEntity delete(Long id) {
        teacherRepository.delete(teacherMapper.dtoToTeacher(findById(id)));
        return ResponseEntity.ok().build();
    }

    public List<TeacherDto> findTeacherByGroupId(Long id) {
        return teacherMapper.teachersToDto(teacherRepository.findTeacherByGroupId(id));
    }

    public TeacherDto update(TeacherDto teacherDto) {
        if (teacherDto.getPassword() != null) {
            teacherDto.setPassword(passwordEncoder.encode(teacherDto.getPassword()));
        }
        Teacher currentUser = teacherMapper.dtoToTeacher(findById(teacherDto.getId()));
        User updateUser = teacherMapper.dtoToTeacher(teacherDto);
        modelMapper.map(updateUser, currentUser);
        return teacherMapper.teacherToDto(teacherRepository.save(currentUser));
    }

    public TeacherDto convertTeacherToDto(Teacher teacher) {
        return teacherMapper.teacherToDto(teacher);
    }

    public TeacherDto findTeacherByEmail(String email) {
        Teacher teacher = teacherRepository.findTeacherByEmail(email);
        TeacherDto teacherDto = teacherMapper.teacherToDto(teacher);
        if (teacher.getUrl() == null) {
            teacherDto.setUrl("https://instagram.fdnk1-1.fna.fbcdn.net/vp/53a7c63e343bca3099b9f23a1cfcb8a5/5E8CABE1/t51.2885-19/s320x320/72875015_1368029390037558_6816249923525148672_n.jpg?_nc_ht=instagram.fdnk1-1.fna.fbcdn.net");
        }
        //todo set subject
//        teacherDto.setSubject();
        return teacherDto;
    }
}
