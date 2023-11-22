package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.GradeDTO;
import com.example.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GradeConverter implements GenericConverter<Grade, GradeDTO> {

    @Autowired
    private RegisterConverter registerConverter;
    @Autowired
    private CoefficientConverter coefficientConverter;
    @Override
    public Grade toEntity(GradeDTO dto) {
        Grade grade = Grade.builder()
                .infoGrade(dto.getInfoGrade())
                .gpa(dto.gpa())
                .coefficient(coefficientConverter.toEntity(dto.getCoefficient()))
                .build();
        return grade;
    }

    @Override
    public GradeDTO toDto(Grade entity) {
        return GradeDTO.builder()
                .infoGrade(entity.getInfoGrade())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .registerDTO(registerConverter.toDto(entity.getRegister()))
                .gpa(entity.getGpa())
                .id(entity.getId())
                .coefficient(entity.getCoefficient() != null ?
                        coefficientConverter.toDto(entity.getCoefficient())
                        : null)
                .build();
    }

    @Override
    public Grade toEntity(Grade entity, GradeDTO dto) {
        return entity.toBuilder()
                .infoGrade(dto.getInfoGrade())
                .gpa(dto.getGpa())
                .build();
    }

    @Override
    public GradeDTO toDto(GradeDTO dto, Grade entity) {
        return null;
    }

    @Override
    public List<GradeDTO> dtoList(List<Grade> entityList) {
        return entityList.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }


}
