package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentRequestExchangeDTO;
import com.example.entity.StudentRequestExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentRequestExchangeConverter
        implements GenericConverter<StudentRequestExchange, StudentRequestExchangeDTO> {

    @Autowired
    private StudentExchangeRegisterConverter studentExchangeRegisterConverter;

    @Override
    public StudentRequestExchange toEntity(StudentRequestExchangeDTO dto) {
        return null;
    }

    @Override
    public StudentRequestExchangeDTO toDto(StudentRequestExchange entity) {
        return StudentRequestExchangeDTO
                .builder()
                .statusExchange(entity.getStatusExchange())
                .statusRequest(entity.getStatusRequest())
                .id(entity.getId())
                .studentExchangeRegisterDTO(studentExchangeRegisterConverter
                        .dtoList(entity.getStudentExchangeRegisters()))
                .build();
    }

    @Override
    public StudentRequestExchange toEntity(StudentRequestExchange entity, StudentRequestExchangeDTO dto) {
        return null;
    }

    @Override
    public StudentRequestExchangeDTO toDto(StudentRequestExchangeDTO dto, StudentRequestExchange entity) {
        return null;
    }

    @Override
    public List<StudentRequestExchangeDTO> dtoList(List<StudentRequestExchange> entityList) {
        return null;
    }
}
