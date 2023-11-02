package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentExchangeRegisterDTO;
import com.example.entity.StudentExchangeRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentExchangeRegisterConverter
        implements GenericConverter<StudentExchangeRegister, StudentExchangeRegisterDTO> {

    @Autowired
    private RegisterConverter registerConverter;


    @Override
    public StudentExchangeRegister toEntity(StudentExchangeRegisterDTO dto) {
        return StudentExchangeRegister
                .builder()
                .status(true)
                .build();
    }

    @Override
    public StudentExchangeRegisterDTO toDto(StudentExchangeRegister entity) {
        return StudentExchangeRegisterDTO
                .builder()
                .id(entity.getId())
                .createBy(entity.getCreateBy())
                .status(entity.getStatus())
                .registerDTO(registerConverter.dtoList(entity.getRegisters()))
                .build();
    }

    @Override
    public StudentExchangeRegister toEntity(StudentExchangeRegister entity, StudentExchangeRegisterDTO dto) {
        return null;
    }

    @Override
    public StudentExchangeRegisterDTO toDto(StudentExchangeRegisterDTO dto, StudentExchangeRegister entity) {
        return null;
    }

    @Override
    public List<StudentExchangeRegisterDTO> dtoList(List<StudentExchangeRegister> entityList) {
        return entityList.stream().map(l -> toDto(l)).collect(Collectors.toList());
    }
}
