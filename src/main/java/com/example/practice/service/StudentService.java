package com.example.practice.service;

import com.example.practice.model.dto.StudentDto;
import com.example.practice.model.entity.Position;
import com.example.practice.model.entity.Student;
import com.example.practice.model.mapper.StudentMapper;
import com.example.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ClassService classService;

    public List<Student> getAll(Integer page, Integer offset) {
        Pageable pageable = PageRequest.of(page, offset, Sort.by("id").descending());
        return studentRepository.findAll(pageable).getContent();
    }

    public Student save(StudentDto studentDto) {
        Student studentEntity = StudentMapper.INSTANCE.toEntity(studentDto);
        studentEntity.setPosition(positionService.findById(studentDto.getPosition().getId()).get());
        studentEntity.setaClass(classService.findById(studentDto.getaClass().getId()).get());

        return studentRepository.save(studentEntity);
    }

}
