package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.SubjectDTO;
import com.example.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component("subjectConverter")
public class SubjectConverter implements GenericConverter<Subject, SubjectDTO> {

    @Autowired
    private TimeTableConverter timeTableConverter;

    @Override
    public Subject toEntity(SubjectDTO dto) {
        return Subject.builder()
                .subjectName(dto.getSubjectName())
                .subjectCode(dto.getSubjectCode())
                .credit(dto.getCredit())
                .majors(new HashSet<>())
                .nameCollectSubject(dto.getNameCollectSubject())
                .build();
    }

    @Override
    public SubjectDTO toDto(Subject entity) {

        return SubjectDTO.builder()
                .subjectCode(entity.getSubjectCode())
                .subjectName(entity.getSubjectName())
                .id(entity.getId())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .credit(entity.getCredit())
                .nameCollectSubject(entity.getNameCollectSubject())
//                .majorCode(entity.getMajors().stream()
//                        .map((v) -> v.getMajorCode()).collect(Collectors.toSet()))
                .timeTableDTOS(entity.getTimeTables()
                        .stream()
                        .map(t -> timeTableConverter.toDto(t))
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public Subject toEntity(Subject entity, SubjectDTO dto) {
        return entity.toBuilder()
                .subjectName(dto.getSubjectName())
                .credit(dto.getCredit()).build();
    }

    @Override
    public SubjectDTO toDto(SubjectDTO dto, Subject entity) {
        return null;
    }


    @Override
    public List<SubjectDTO> dtoList(List<Subject> entityList) {
       return entityList.stream().map(s -> toDto(s)).collect(Collectors.toList());
    }


}
