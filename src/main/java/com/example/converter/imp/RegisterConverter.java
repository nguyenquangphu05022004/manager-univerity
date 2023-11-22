package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.RegisterDTO;
import com.example.dto.TimeTableDTO;
import com.example.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component("registerConverter")
public class RegisterConverter implements GenericConverter<Register, RegisterDTO> {
    @Autowired
    private TimeTableConverter timeTableConverter;
    @Autowired
    private TuitionConverter tuitionConverter;
    @Override
    public Register toEntity(RegisterDTO dto) {
        return null;
    }

    @Override
    public RegisterDTO toDto(Register entity) {
        RegisterDTO.InfoRegisterOfMajor infoRegisterOfMajor
                = RegisterDTO
                .InfoRegisterOfMajor
                .builder()
                .registerOfMajorId(entity.getRegisterOfMajor().getId())
                .tuitionDTO(tuitionConverter.toDto(entity.getRegisterOfMajor().getTuition()))
                .build();
        return RegisterDTO.builder()
                .id(entity.getId())
                .studentId(entity.getStudent().getId())
                .timeTableDTO(timeTableConverter.toDto(entity.getTimeTable()))
                .isExchange(entity.getIsExchange())
                .infoRegisterOfMajor(infoRegisterOfMajor)
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
