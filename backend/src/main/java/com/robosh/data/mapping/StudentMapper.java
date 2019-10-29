package com.robosh.data.mapping;

import com.robosh.data.dto.StudentDto;
import com.robosh.data.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto studentToDto(Student student);

    Student dtoToStudent(StudentDto studentDto);
}
