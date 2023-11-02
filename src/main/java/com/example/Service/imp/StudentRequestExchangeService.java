package com.example.Service.imp;

import com.example.converter.imp.StudentRequestExchangeConverter;
import com.example.dto.StudentRequestExchangeDTO;
import com.example.entity.Register;
import com.example.entity.StudentExchangeRegister;
import com.example.entity.StudentRequestExchange;
import com.example.repository.StudentRequestExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRequestExchangeService {
    @Autowired
    private GenericSearchBy searchBy;

    @Autowired
    private StudentRequestExchangeRepository studentRequestExchangeRepository;

    @Autowired
    private StudentRequestExchangeConverter studentRequestExchangeConverter;


    public StudentRequestExchangeDTO sendRequest(Long studentRequestExchangeId) {

        StudentExchangeRegister studentExchangeRegister =
                searchBy.findStudentExchangeRegisterById(studentRequestExchangeId);

        StudentRequestExchange requestExchange = StudentRequestExchange
                .builder()
                .statusExchange(false)
                .statusRequest(true)
                .studentExchangeRegisters(new ArrayList<>())
                .build();
        requestExchange.getStudentExchangeRegisters().add(studentExchangeRegister);

        return studentRequestExchangeConverter
                .toDto(
                        studentRequestExchangeRepository
                                .save(requestExchange)
                );
    }

    public List<StudentRequestExchange> getAlllist() {
        return null;
    }

    public List<StudentRequestExchangeDTO> getListByUsername() {
        List<StudentRequestExchange> list =
                studentRequestExchangeRepository
                        .findAllByCreateBy(
                                SecurityContextHolder
                                        .getContext()
                                        .getAuthentication()
                                        .getName()
                        );
        List<StudentRequestExchangeDTO> dtoList = new ArrayList<>();
        list.forEach((l) -> {
            dtoList.add(studentRequestExchangeConverter.toDto(l));
        });
        return dtoList;
    }


}
