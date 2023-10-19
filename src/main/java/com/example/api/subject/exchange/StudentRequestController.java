package com.example.api.subject.exchange;

import com.example.Service.imp.RegisterSubjectService;
import com.example.Service.imp.StudentRequestService;
import com.example.dto.StudentRequestDTO;
import com.example.entity.StudentRequest;
import com.example.entity.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class StudentRequestController {

    @Autowired
    private StudentRequestService studentRequestService;

    @PostMapping("/api/student/subject/rq/{registerId}")
    public  StudentRequestDTO addRequest(@PathVariable Long registerId) {
        return studentRequestService.save(registerId);
    }

    @PutMapping("/api/student/subject/rq/cf/{studentRequestId}/{studentResponseId}")
    public ResponseEntity<?> confirmStudentResponse(
            @PathVariable Long studentRequestId,
            @PathVariable Long studentResponseId
    ) {
        return studentRequestService.confirm(studentRequestId, studentResponseId)
                ? ResponseEntity.ok("Success") : ResponseEntity.ok("Fail");
    }

    @GetMapping("/api/student/subject/rq")
    public List<StudentRequestDTO> getAllRequest() {
        return studentRequestService.list();
    }
    @GetMapping("/api/student/subject/rq/cr")
    public List<StudentRequestDTO> getAllRequestOfStudentCurrent() {
        return studentRequestService.getListByUsername();
    }


}
