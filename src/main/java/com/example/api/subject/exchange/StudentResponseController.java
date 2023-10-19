package com.example.api.subject.exchange;

import com.example.Service.imp.StudentRequestService;
import com.example.Service.imp.StudentResponseService;
import com.example.dto.StudentRequestDTO;
import com.example.dto.StudentResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentResponseController {

    @Autowired
    private StudentResponseService studentResponseService;

    @PostMapping("/api/student/subject/rp/{studentRequestId}")
    public StudentResponseDTO addResponse(@PathVariable("studentRequestId") Long studentRequestId) {
        return studentResponseService.save(studentRequestId);
    }
    @GetMapping("/api/student/subject/rp/{subjectId}")
    public List<StudentResponseDTO> getListStudentResponseByStudentCurrent(@PathVariable("subjectId") Long subjectId) {
        return studentResponseService.getByUsernameAndSubjectId(subjectId);
    }

}