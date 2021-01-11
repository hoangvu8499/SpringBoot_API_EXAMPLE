package com.example.practice.model.mapper;

import com.example.practice.model.dto.StudentDto;
import com.example.practice.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    default List<StudentDto> toDtoList(List<Student> studentList) {
        if (studentList == null) {
            return new ArrayList<>();
        }
        return studentList.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<Student> toEntityList(List<StudentDto> studentList) {
        if (studentList == null) {
            return new ArrayList<>();
        }
        return studentList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
