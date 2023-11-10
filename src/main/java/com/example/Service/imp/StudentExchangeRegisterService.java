package com.example.Service.imp;

import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.StudentExchangeRegisterConverter;
import com.example.dto.StudentExchangeRegisterDTO;
import com.example.entity.Person;
import com.example.entity.Register;
import com.example.entity.Student;
import com.example.entity.StudentExchangeRegister;
import com.example.repository.StudentExchangeRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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

        Person person = searchBy.findPersonByUsername(
                SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()
        );
        boolean isExistsRegister = isExistsRegister(person.getStudent(), register);
        if(isExistsRegister) {
            StudentExchangeRegister studentExchangeRegister =
                    StudentExchangeRegister
                            .builder()
                            .statusExchange(false)
                            .student(person.getStudent())
                            .register(register)
                            .statusRequest(true)
                            .build();

            return studentExchangeRegisterConverter
                    .toDto(
                            studentExchangeRegisterRepository
                                    .save(studentExchangeRegister)
                    );
        } else {
            return null;
        }

    }

    private boolean isExistsRegister(Student student, Register register) {
        for(Register r : student.getRegisters()) {
            if(r.equals(register)) {
                return true;
            }
        }
        return false;
    }

    public List<StudentExchangeRegisterDTO> getListExchangeByRegisterOfMajorId(Long registerOfMajorId) {
        return studentExchangeRegisterConverter
                .dtoList(
                        studentExchangeRegisterRepository
                                .findAllByRegisterOfMajorIdCustom(registerOfMajorId)
                );
    }


}
