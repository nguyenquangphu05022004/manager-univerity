package com.example.Service.imp.response.impl;

import com.example.Service.imp.response.IResponseService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.entity.Register;
import com.example.entity.Student;
import com.example.entity.StudentExchangeRegister;
import com.example.entity.StudentRequestExchange;
import com.example.repository.RegisterRepository;
import com.example.repository.StudentExchangeRegisterRepository;
import com.example.repository.StudentRequestExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("responseExchangeSubject")
public class ResponseExchangeSubject implements IResponseService {

    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private StudentRequestExchangeRepository studentRequestExchangeRepository;
    @Autowired
    private StudentExchangeRegisterRepository studentExchangeRegisterRepository;
    @Autowired
    private GenericSearchBy searchBy;

    private Boolean save(StudentRequestExchange studentRequestExchange,
                         StudentExchangeRegister studentExchangeRegister) {
        studentExchangeRegister = studentExchangeRegisterRepository
                .save(studentExchangeRegister
                        .toBuilder()
                        .statusExchange(true)
                        .build());

        studentRequestExchange = studentRequestExchangeRepository
                .save(studentRequestExchange
                        .toBuilder()
                        .statusExchange(true)
                        .build());

        return studentRequestExchange != null && studentExchangeRegister != null;
    }

    private Boolean save(Register register, Student student) {
        return registerRepository
                .save(register
                        .toBuilder()
                        .student(student)
                        .build()) != null ? true : false;

    }

    @Transactional
    @Modifying
    @Override
    public Boolean confirm(Object... params) {
        StudentExchangeRegister studentExchangeRegister
                = searchBy.findStudentExchangeRegisterById((Long)params[0]);
        StudentRequestExchange studentRequestExchange
                = searchBy.findStudentRequestExchangeById((Long)params[1]);
        return save(studentExchangeRegister.getRegister(),
                studentRequestExchange.getStudent()) &&
                save(studentRequestExchange.getRegister(),
                        studentExchangeRegister.getStudent()) &&
                save(studentRequestExchange, studentExchangeRegister);
    }
}
