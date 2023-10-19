package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.SchoolYearDTO;

import com.example.entity.SchoolYear;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SchoolYearConverter implements GenericConverter<SchoolYear, SchoolYearDTO> {
    @Autowired
    private SemesterConverter semesterConverter;

    @Override
    public SchoolYear toEntity(SchoolYearDTO dto) {
        return null;
    }

    @Override
    public SchoolYearDTO toDto(SchoolYear entity) {
        SchoolYearDTO schoolYearDTO =  SchoolYearDTO.builder()
                .schoolYear(entity.getSchoolYear())
                .id(entity.getId())
                .semesters(semesterConverter.dtoList(entity.getSemesters()))
                .courseId(entity.getCourses().get(0).getId())
                .courseCode(entity.getCourses().get(0).getCode())
                .build();
        return schoolYearDTO;
    }

    @Override
    public SchoolYear toEntity(SchoolYear entity, SchoolYearDTO dto) {
        return null;
    }

    @Override
    public SchoolYearDTO toDto(SchoolYearDTO dto, SchoolYear entity) {
        return null;
    }

    @Override
    public List<SchoolYearDTO> dtoList(List<SchoolYear> entityList) {
        List<SchoolYearDTO> dtoList = new ArrayList<>();
        entityList.forEach((c) -> {
            dtoList.add(toDto(c));
        });
        return dtoList;
    }
}
