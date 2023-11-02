package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.RegisterDTO;
import com.example.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("registerConverter")
public class RegisterConverter implements GenericConverter<Register, RegisterDTO> {
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private RegisterOfMajorConverter registerOfMajorConverter;
    @Override
    public Register toEntity(RegisterDTO dto) {
        return null;
    }

    @Override
    public RegisterDTO toDto(Register entity) {
        return RegisterDTO.builder()
                .id(entity.getId())
                .studentId(entity.getStudent().getId())
                .status(entity.getStatus())
                .subjectDTO(subjectConverter.toDto(entity.getSubject()))
                .registerOfMajorId(entity.getRegisterOfMajor().getId())
                .build();
    }

    @Override
    public Register toEntity(Register entity, RegisterDTO dto) {
        return null;
    }

    @Override
    public RegisterDTO toDto(RegisterDTO dto, Register entity) {
        return null;
    }

    @Override
    public List<RegisterDTO> dtoList(List<Register> entityList) {
        return entityList
                .stream()
                .map((e) -> {
                    return toDto(e);
                })
                .collect(Collectors.toList());
    }
}
