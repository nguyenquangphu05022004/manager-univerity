package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.SemesterDTO;
import com.example.entity.Semester;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SemesterConverter implements GenericConverter<Semester, SemesterDTO> {
    @Override
    public Semester toEntity(SemesterDTO dto) {
        return null;
    }

    @Override
    public SemesterDTO toDto(Semester entity) {
        return SemesterDTO.builder()
                .id(entity.getId())
                .semesterEnum(entity.getSemester())
                .semester(entity.getSemester().getName())
                .build();

    }

    @Override
    public Semester toEntity(Semester entity, SemesterDTO dto) {
        return null;
    }

    @Override
    public SemesterDTO toDto(SemesterDTO dto, Semester entity) {
        return null;
    }

    @Override
    public List<SemesterDTO> dtoList(List<Semester> entityList) {
        return entityList.stream().map((s) -> {
            return toDto(s);
        }).collect(Collectors.toList());
    }
}
