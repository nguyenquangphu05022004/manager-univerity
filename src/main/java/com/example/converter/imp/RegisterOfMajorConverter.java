package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.CourseDTO;
import com.example.dto.RegisterOfMajorDTO;
import com.example.entity.Major;
import com.example.entity.RegisterOfMajor;
import com.example.entity.Semester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RegisterOfMajorConverter implements GenericConverter<RegisterOfMajor, RegisterOfMajorDTO> {

    @Autowired
    private SemesterConverter semesterConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private SchoolYearConverter schoolYearConverter;
    @Autowired
    private MajorConverter majorConverter;


    @Override
    public RegisterOfMajor toEntity(RegisterOfMajorDTO dto) {
        return null;
    }

    @Override
    public RegisterOfMajorDTO toDto(RegisterOfMajor entity) {
        return RegisterOfMajorDTO.builder()
                .semesterDTO(semesterConverter.toDto(entity.getSemester()))
                .majorDTO(majorConverter.toDto(entity.getMajor()))
                .subjects(subjectConverter.dtoList(entity.getSubjects()))
                .schoolYearDTO(schoolYearConverter.toDto(entity.getSchoolYears().get(0)))
                .build();
    }

    @Override
    public RegisterOfMajor toEntity(RegisterOfMajor entity, RegisterOfMajorDTO dto) {
        return null;
    }

    @Override
    public RegisterOfMajorDTO toDto(RegisterOfMajorDTO dto, RegisterOfMajor entity) {
        return null;
    }

    @Override
    public List<RegisterOfMajorDTO> dtoList(List<RegisterOfMajor> entityList) {
        return entityList.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }
}
