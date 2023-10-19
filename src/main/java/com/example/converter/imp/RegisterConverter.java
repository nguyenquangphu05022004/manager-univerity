package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.RegisterDTO;
import com.example.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("registerConverter")
public class RegisterConverter implements GenericConverter<Register, RegisterDTO> {
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private GroupConverter groupConverter;

    @Override
    public Register toEntity(RegisterDTO dto) {
        return null;
    }

    @Override
    public RegisterDTO toDto(Register entity) {
        return RegisterDTO.builder()
                .id(entity.getId())
                .groupDTO(groupConverter.toDto(entity.getGroup()))
                .subjectDTO(subjectConverter.toDto(entity.getSubject()))
                .studentDTO(studentConverter.toDto(entity.getStudent()))
                .status(entity.getStatus())
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
        List<RegisterDTO> list = new ArrayList<>();
        entityList.forEach((register -> {
            list.add(toDto(register));
        }));
        return list;
    }
}
