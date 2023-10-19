package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.StudentResponseConverter;
import com.example.dto.StudentResponseDTO;
import com.example.entity.*;
import com.example.repository.RegisterRepository;
import com.example.repository.StudentRequestRepository;
import com.example.repository.StudentResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseService implements GenericService<StudentResponseDTO> {

    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private StudentResponseConverter studentResponseConverter;
    @Autowired
    private StudentResponseRepository studentResponseRepository;

    public StudentResponseDTO save(Long studentRequestId) {
        StudentRequest studentRequest =
                searchBy.findStudentRequestById(studentRequestId);

        List<StudentRequest> requests = new ArrayList<>();
        requests.add(studentRequest);

        Student student =
                searchBy.findStudentByUsername(
                        SecurityContextHolder.getContext()
                                .getAuthentication().getName());

        Register register = searchBy
                .findRegisterByStudentIdAndSubjectId
                        (student.getId(), studentRequest.getSubjectRequest().getId());

        StudentResponse studentResponse =
                StudentResponse
                        .builder()
                        .groupResponse(register.getGroup())
                        .subjectResponse(register.getSubject())
                        .studentResponse(student)
                        .status(false)
                        .studentRequests(requests)
                        .exchange(true)
                        .build();

        return studentResponseConverter
                .toDto(studentResponseRepository.save(
                        studentResponse
                ));
    }

    public List<StudentResponseDTO> getByUsernameAndSubjectId(Long subjectId) {
        StudentRequest studentRequest =
                searchBy
                        .findStudentRequestByUsernameAndSubjectIdAndStatus
                                (SecurityContextHolder
                                                .getContext()
                                                .getAuthentication()
                                                .getName(),
                                        subjectId,
                                        false);
        List<StudentResponseDTO> list = new ArrayList<>();
        studentRequest.getStudentResponses().forEach((e) -> {
            list.add(studentResponseConverter.toDto(e));
        });
        return list;
    }

    @Override
    public StudentResponseDTO save(StudentResponseDTO object) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<StudentResponseDTO> list() {
        return null;
    }

    @Override
    public StudentResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public List<StudentResponseDTO> getByCode(String code) {
        return null;
    }
}
