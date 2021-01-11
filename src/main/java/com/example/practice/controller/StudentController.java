package com.example.practice.controller;

import com.example.practice.model.dto.StudentDto;
import com.example.practice.model.entity.Student;
import com.example.practice.model.mapper.StudentMapper;
import com.example.practice.service.PositionService;
import com.example.practice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired private StudentService studentService;

    @GetMapping("/get-student")
    public List<StudentDto> getAll(@RequestParam int page, @RequestParam int offset){
        List<Student> listStudent = studentService.getAll(page, offset);
        if(listStudent.isEmpty()){
            return new ArrayList<>();
        }
        return StudentMapper.INSTANCE.toDtoList(listStudent);
    }

    @PostMapping("/save-student")
    public StudentDto save(@RequestBody StudentDto studentDto){
        Student student = studentService.save(studentDto);
        return StudentMapper.INSTANCE.toDto(student);
    }
}
