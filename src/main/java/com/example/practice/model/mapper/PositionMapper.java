package com.example.practice.model.mapper;

import com.example.practice.model.dto.PositionDto;
import com.example.practice.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PositionMapper {
    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

    Position toEntity(PositionDto positionDto);

    PositionDto toDto(Position position);

    default List<PositionDto> toDtoList(List<Position> positionList) {
        if (positionList == null) {
            return new ArrayList<>();
        }
        return positionList.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<Position> toEntityList(List<PositionDto> positionList) {
        if (positionList == null) {
            return new ArrayList<>();
        }
        return positionList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
