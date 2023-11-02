package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.SubjectDTO;
import com.example.dto.TeacherDTO;
import com.example.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("teacherConverter")
public class TeacherConverter implements GenericConverter<Teacher, TeacherDTO> {

    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Override
    public Teacher toEntity(TeacherDTO dto) {
        return Teacher
                .builder()
                .build();
    }

    @Override
    public TeacherDTO toDto(Teacher entity) {
        return TeacherDTO
                .builder()
                .id(entity.getId())
                .person(personConverter.toDto(entity.getPerson()))
                .build();
    }

    @Override
    public Teacher toEntity(Teacher entity, TeacherDTO dto) {
        return entity
                .toBuilder()
                .person(personConverter.toEntity(dto.getPerson()))
                .build();
    }

    @Override
    public TeacherDTO toDto(TeacherDTO dto, Teacher entity) {
        return null;
    }


    @Override
    public List<TeacherDTO> dtoList(List<Teacher> entityList) {
        return entityList.stream().map(t -> toDto(t)).collect(Collectors.toList());
    }


}
