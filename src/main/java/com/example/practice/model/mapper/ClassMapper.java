package com.example.practice.model.mapper;

import com.example.practice.model.dto.ClassDto;
import com.example.practice.model.dto.StudentDto;
import com.example.practice.model.entity.Class;
import com.example.practice.model.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ClassMapper {
    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    Class toEntity(ClassDto aClassDto);

    ClassDto toDto(Class aClass);

    default List<ClassDto> toDtoList(List<Class> classList){
        if(classList == null){
            return new ArrayList<>();
        }
        return classList.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<Class> toEntityList(List<ClassDto> classList){
        if(classList == null){
            return new ArrayList<>();
        }
        return classList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
