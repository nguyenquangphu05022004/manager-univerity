package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentResponseDTO;
import com.example.entity.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentResponseConverter implements GenericConverter<StudentResponse, StudentResponseDTO> {
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private GroupConverter groupConverter;

    @Override
    public StudentResponse toEntity(StudentResponseDTO dto) {
        return null;
    }

    @Override
    public StudentResponseDTO toDto(StudentResponse entity) {
        return StudentResponseDTO.builder()
                .id(entity.getId())
                .groupResponse(groupConverter.toDto(entity.getGroupResponse()))
                .studentResponse(studentConverter.toDto(entity.getStudentResponse()))
                .subjectResponse(subjectConverter.toDto(entity.getSubjectResponse()))
                .exchange(entity.getExchange())
                .build();
    }

    @Override
    public StudentResponse toEntity(StudentResponse entity, StudentResponseDTO dto) {
        return null;
    }

    @Override
    public StudentResponseDTO toDto(StudentResponseDTO dto, StudentResponse entity) {
        return null;
    }

    @Override
    public List<StudentResponseDTO> dtoList(List<StudentResponse> entityList) {
        return null;
    }
}
