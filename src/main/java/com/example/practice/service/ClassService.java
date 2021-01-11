package com.example.practice.service;

import com.example.practice.model.entity.Class;
import com.example.practice.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public Optional<Class> findById(Integer id) {
        return classRepository.findById(id);
    }

}
