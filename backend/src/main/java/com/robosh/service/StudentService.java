package com.robosh.service;

import com.robosh.data.dto.StudentDto;
import com.robosh.data.entity.Student;
import com.robosh.data.entity.User;
import com.robosh.data.mapping.StudentMapper;
import com.robosh.data.repository.StudentRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final BCryptPasswordEncoder passwordEncoder;
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private ModelMapper modelMapper;
    private MailSenderService mailSenderService;

    @Value("${email.registration.subject}")
    private String emailRegistrationSubject;

    @Value("${email.registration.message}")
    private String emailRegistrationMessage;

    @Autowired
    public StudentService(BCryptPasswordEncoder passwordEncoder, StudentRepository studentRepository, ModelMapper modelMapper, MailSenderService mailSenderService) {
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
        this.mailSenderService = mailSenderService;
        studentMapper = StudentMapper.INSTANCE;
    }

    public List<StudentDto> findStudentByGroupId(Long id) {
        return studentMapper.studentsToDto(studentRepository.findStudentByGroupId(id));
    }

    public Student saveStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        return studentRepository.save(student);
    }

    @Transactional
    public StudentDto save(StudentDto studentDto) {
        String password = studentDto.getPassword();
        studentDto.setPassword(passwordEncoder.encode(password));
        studentDto = studentMapper.studentToDto(studentRepository.save(studentMapper.dtoToStudent(studentDto)));
        String registrationMessage = String.format(emailRegistrationMessage,
                studentDto.getLastName() + " " + studentDto.getFirstName() + " " + studentDto.getSecondName(),
                studentDto.getEmail(),
                password);
        mailSenderService.send(studentDto.getEmail(), emailRegistrationSubject, registrationMessage);
        return studentDto;
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id)
        );
    }

    public StudentDto findByStudentId(Long id) {
        return studentMapper.studentToDto(findById(id));
    }

    public ResponseEntity delete(Long id) {
        studentRepository.delete(findById(id));
        return ResponseEntity.ok().build();
    }

    public List<StudentDto> findAll() {
        return studentMapper.studentsToDto(studentRepository.findAll());
    }

    public StudentDto update(StudentDto studentDto) {
        if (studentDto.getPassword() != null) {
            studentDto.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        }
        Student currentUser = findById(studentDto.getId());
        User updateUser = studentMapper.dtoToStudent(studentDto);
        modelMapper.map(updateUser, currentUser);
        return studentMapper.studentToDto(studentRepository.save(currentUser));
    }

    public StudentDto convertStudentToDto(Student student) {
        return studentMapper.studentToDto(student);
    }
}
