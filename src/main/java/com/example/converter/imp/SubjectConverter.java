package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.MajorDTO;
import com.example.dto.SubjectDTO;
import com.example.entity.Major;
import com.example.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component("subjectConverter")
public class SubjectConverter implements GenericConverter<Subject, SubjectDTO> {

    @Autowired
    private MajorConverter majorConverter;

    @Override
    public Subject toEntity(SubjectDTO dto) {
        return Subject.builder().endDate(dto.getEndDate())
                .startDate(dto.getStartDate())
                .subjectName(dto.getSubjectName())
                .subjectCode(dto.getSubjectCode())
                .credit(dto.getCredit())
                .groups(new HashSet<>())
                .majors(new HashSet<>())
                .build();
    }

    @Override
    public SubjectDTO toDto(Subject entity) {

        return SubjectDTO.builder()
                .endDate(entity.getEndDate())
                .startDate(entity.getStartDate())
                .subjectCode(entity.getSubjectCode())
                .subjectName(entity.getSubjectName())
                .id(entity.getId()).createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .credit(entity.getCredit())
                .groupId(entity.getGroups().stream()
                .map((v) -> v.getId()).collect(Collectors.toList()))
                .majorCode(entity.getMajors().stream()
                .map((v)-> v.getMajorCode()).collect(Collectors.toSet()))
                .groupCode(entity.getGroups().stream()
                .map((v) -> v.getCode()).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Subject toEntity(Subject entity, SubjectDTO dto) {
        return entity.toBuilder().startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .subjectName(dto.getSubjectName())
                .credit(dto.getCredit()).build();
    }

    @Override
    public SubjectDTO toDto(SubjectDTO dto, Subject entity) {
        return null;
    }

//    @Override
//    public List<SubjectDTO> dtoList(Set<Subject> entityList) {
//        return null;
//    }

    @Override
    public List<SubjectDTO> dtoList(List<Subject> entityList) {
        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for(Subject subject : entityList) {
            subjectDTOS.add(toDto(subject));
        }
        return subjectDTOS;
    }


}
