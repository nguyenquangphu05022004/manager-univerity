package com.example.Service.imp;

import com.example.converter.imp.StudentExchangeRegisterConverter;
import com.example.dto.StudentExchangeRegisterDTO;
import com.example.entity.Register;
import com.example.entity.StudentExchangeRegister;
import com.example.repository.StudentExchangeRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentExchangeRegisterService{

    @Autowired
    private GenericSearchBy searchBy;

    @Autowired
    private StudentExchangeRegisterRepository studentExchangeRegisterRepository;

    @Autowired
    private StudentExchangeRegisterConverter studentExchangeRegisterConverter;

    public StudentExchangeRegisterDTO exchangeRegister(Long registerId) {

        Register register = searchBy.findRegisterById(registerId);

        StudentExchangeRegister studentExchangeRegister =
                StudentExchangeRegister
                        .builder()
                        .status(true)
                        .registers(new ArrayList<>())
                        .build();

        studentExchangeRegister.getRegisters().add(register);

        return studentExchangeRegisterConverter
                .toDto(
                        studentExchangeRegisterRepository
                                .save(studentExchangeRegister)
                );
    }
    public List<StudentExchangeRegisterDTO> getListExchangeByRegisterOfMajorId(Long registerOfMajorId) {
        return studentExchangeRegisterConverter
                .dtoList(
                        studentExchangeRegisterRepository
                                .findAllByRegisterOfMajorIdCustom(registerOfMajorId)
                );
    }


}
