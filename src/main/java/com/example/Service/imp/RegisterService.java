package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.RegisterConverter;
import com.example.dto.RegisterDTO;
import com.example.entity.*;
import com.example.repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements GenericService<RegisterDTO> {

    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private RegisterConverter registerConverter;

    public RegisterDTO register(Long timeTableId,
            Long registerOfMajorId) {
        Person person = searchBy
                .findPersonByUsername(
                        SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getName());
        TimeTable timeTable = searchBy.findTimeTableById(timeTableId);
        RegisterOfMajor registerOfMajor = searchBy.findRegisterOfMajorById(registerOfMajorId);
        Register register = Register
                .builder()
                .timeTable(timeTable)
                .student(person.getStudent())
                .registerOfMajor(registerOfMajor)
                .isExchange(false)
                .build();
        return registerConverter.toDto(registerRepository.save(register));
    }

    public List<RegisterDTO> getAllRecordOfStudent(Long registerOfMajorId) {
        Person person = searchBy.findPersonByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName());
        List<Register> registers = registerRepository
                .findAllByStudentIdAndRegisterOfMajorId(person.getStudent().getId(), registerOfMajorId);
        return registerConverter.dtoList(registers);
    }

    @Override
    public RegisterDTO save(RegisterDTO object) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    public void delete(Long id) {
        registerRepository.deleteRegisterById(id);
    }

    @Override
    public List<RegisterDTO> list() {
        return null;
    }

}
