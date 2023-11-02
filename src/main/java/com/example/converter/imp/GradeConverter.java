package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.GradeDTO;
import com.example.entity.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class GradeConverter implements GenericConverter<Grade, GradeDTO> {

    @Autowired
    private RegisterConverter registerConverter;

    @Override
    public Grade toEntity(GradeDTO dto) {
        Grade grade = Grade.builder()
                .attend(dto.getAttend())
                .endOfTerm(dto.getEndOfTerm())
                .midterm(dto.getMidterm())
                .practice(dto.getPractice())
                .test(dto.getTest())
                .gpa(dto.gpa())
                .build();
        return grade;
    }

    @Override
    public GradeDTO toDto(Grade entity) {
        return GradeDTO.builder()
                .attend(entity.getAttend()).endOfTerm(entity.getEndOfTerm())
                .midterm(entity.getMidterm()).practice(entity.getPractice())
                .test(entity.getTest())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .registerDTO(registerConverter.toDto(entity.getRegister()))
                .gpa(entity.getGpa())
                .id(entity.getId())
                .build();
    }

    @Override
    public Grade toEntity(Grade entity, GradeDTO dto) {

        return entity.toBuilder()
                .attend(dto.getAttend())
                .endOfTerm(dto.getEndOfTerm())
                .midterm(dto.getMidterm())
                .practice(dto.getPractice())
                .test(dto.getTest())
                .gpa(dto.getGpa()).build();
    }

    @Override
    public GradeDTO toDto(GradeDTO dto, Grade entity) {
        return null;
    }

    @Override
    public List<GradeDTO> dtoList(List<Grade> entityList) {
        List<GradeDTO> dtoList = new ArrayList<>();
        for (Grade entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }




}
