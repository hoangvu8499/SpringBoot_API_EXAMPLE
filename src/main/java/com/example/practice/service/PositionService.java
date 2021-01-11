package com.example.practice.service;

import com.example.practice.model.entity.Class;
import com.example.practice.model.entity.Position;
import com.example.practice.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {
    @Autowired private PositionRepository positionRepository;

    public List<Position> getAll(Integer page, Integer offset ){
        Pageable pageable = PageRequest.of(page , offset, Sort.by("id").descending());
        return positionRepository.findAll(pageable).getContent();
    }

    public Optional<Position> findById(Integer id) {
        return positionRepository.findById(id);
    }

}
