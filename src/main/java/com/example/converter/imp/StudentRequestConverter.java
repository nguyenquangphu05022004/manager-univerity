package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentDTO;
import com.example.dto.StudentRequestDTO;
import com.example.entity.Group;
import com.example.entity.Register;
import com.example.entity.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRequestConverter implements GenericConverter<StudentRequest, StudentRequestDTO> {

    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private GroupConverter groupConverter;

    @Override
    public StudentRequest toEntity(StudentRequestDTO dto) {
        return null;
    }

    @Override
    public StudentRequestDTO toDto(StudentRequest entity) {

        return StudentRequestDTO.builder()
                .id(entity.getId())
                .groupDTO(groupConverter.toDto(entity.getGroupRequest()))
                .subjectDTO(subjectConverter.toDto(entity.getSubjectRequest()))
                .studentDTO(studentConverter.toDto(entity.getStudentRequest()))
                .exchange(true)
                .build();
    }

    @Override
    public StudentRequest toEntity(StudentRequest entity, StudentRequestDTO dto) {
        return null;
    }

    @Override
    public StudentRequestDTO toDto(StudentRequestDTO dto, StudentRequest entity) {
        return null;
    }

    @Override
    public List<StudentRequestDTO> dtoList(List<StudentRequest> entityList) {
        return null;
    }


}
