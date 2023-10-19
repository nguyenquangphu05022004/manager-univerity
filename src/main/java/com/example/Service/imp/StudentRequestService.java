package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.StudentRequestConverter;
import com.example.dto.StudentRequestDTO;
import com.example.entity.Register;
import com.example.entity.StudentRequest;
import com.example.entity.StudentResponse;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.RegisterRepository;
import com.example.repository.StudentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentRequestService {
    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private RegisterRepository registerRepository;
    @Autowired
    private StudentRequestRepository studentRequestRepository;
    @Autowired
    private StudentRequestConverter studentRequestConverter;

    public StudentRequestDTO save(Long registerId) {
        Register register = searchBy.findRegisterById(registerId);
        List<Register> registers = new ArrayList<>();
        registers.add(register);
        StudentRequest studentRequest =
                StudentRequest.builder()
                        .groupRequest(register.getGroup())
                        .subjectRequest(register.getSubject())
                        .studentRequest(register.getStudent())
                        .status(false)
                        .exchange(true)
                        .build();
        registerRepository.save(register.toBuilder().status(true).build());
        return studentRequestConverter
                .toDto(studentRequestRepository
                        .save(studentRequest));
    }

    public Boolean confirm(Long studentRequestId, Long studentResponseId) {
        return studentRequestRepository.confirmResponse(studentRequestId, studentResponseId);
    }

    public List<StudentRequestDTO> list() {

        List<StudentRequest> list = studentRequestRepository.findAllByStatus(false);
        List<StudentRequestDTO> dtoList = new ArrayList<>();
        list.forEach((l) -> {
            dtoList.add(studentRequestConverter.toDto(l));
        });
        return dtoList;
    }

    public List<StudentRequestDTO> getListByUsername() {
        List<StudentRequest> list =
                studentRequestRepository
                        .findAllByStudentRequestUsernameAndStatus(
                                SecurityContextHolder
                                        .getContext()
                                        .getAuthentication()
                                        .getName(),
                                false
                        );
        List<StudentRequestDTO> dtoList = new ArrayList<>();
        list.forEach((l) -> {
            dtoList.add(studentRequestConverter.toDto(l));
        });
        return dtoList;
    }


}
