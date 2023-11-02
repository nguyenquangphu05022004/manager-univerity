package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.SemesterOfYearDTO;
import com.example.entity.SemesterOfYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SemesterOfYearConverter implements GenericConverter<SemesterOfYear, SemesterOfYearDTO> {
    @Autowired
    private SemesterConverter semesterConverter;
    @Autowired
    private SchoolYearConverter schoolYearConverter;
    @Override
    public SemesterOfYear toEntity(SemesterOfYearDTO dto) {
        return SemesterOfYear
                .builder()
                .schoolYear(schoolYearConverter.toEntity(dto.getSchoolYearDTO()))
                .semester(semesterConverter.toEntity(dto.getSemesterDTO()))
                .build();
    }

    @Override
    public SemesterOfYearDTO toDto(SemesterOfYear entity) {
        return SemesterOfYearDTO
                .builder()
                .semesterDTO(semesterConverter.toDto(entity.getSemester()))
                .schoolYearDTO(schoolYearConverter.toDto(entity.getSchoolYear()))
                .build();
    }

    @Override
    public SemesterOfYear toEntity(SemesterOfYear entity, SemesterOfYearDTO dto) {
        return null;
    }

    @Override
    public SemesterOfYearDTO toDto(SemesterOfYearDTO dto, SemesterOfYear entity) {
        return null;
    }

    @Override
    public List<SemesterOfYearDTO> dtoList(List<SemesterOfYear> entityList) {
        return null;
    }
}
