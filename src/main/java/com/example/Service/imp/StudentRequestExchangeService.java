package com.example.Service.imp;

import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.StudentRequestExchangeConverter;
import com.example.dto.StudentRequestExchangeDTO;
import com.example.entity.*;
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
        Student student = getStudent();
        Register isEmptyRegister = isEmptyRegister(student, studentExchangeRegister);
        if (isEmptyRegister != null) {
            StudentRequestExchange requestExchange = StudentRequestExchange
                    .builder()
                    .statusExchange(false)
                    .statusRequest(true)
                    .student(student)
                    .register(isEmptyRegister)
                    .studentExchangeRegister(studentExchangeRegister)
                    .build();

            return studentRequestExchangeConverter
                    .toDto(
                            studentRequestExchangeRepository
                                    .save(requestExchange)
                    );
        } else {
            return null;
        }
    }

    private Register isEmptyRegister(Student student,
                                    StudentExchangeRegister studentExchangeRegister) {
        for (Register register : student.getRegisters()) {
            boolean isEqualSubject = register
                    .getTimeTable()
                    .getSubject()
                    .equals(studentExchangeRegister
                            .getRegister()
                            .getTimeTable()
                            .getSubject());
            boolean isEqualGroup = register.getTimeTable().getGroup()
                    .equals(studentExchangeRegister
                            .getRegister()
                            .getTimeTable()
                            .getGroup());
            if (isEqualSubject && !isEqualGroup) {
                return register;
            }
        }
        return null;
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

    private Student getStudent() {
        return searchBy.findPersonByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName()
        ).getStudent();
    }


}
