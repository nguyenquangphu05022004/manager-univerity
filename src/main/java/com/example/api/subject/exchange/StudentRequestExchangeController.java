package com.example.api.subject.exchange;

import com.example.Service.imp.StudentRequestExchangeService;
import com.example.dto.StudentRequestExchangeDTO;
import com.example.entity.StudentRequestExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentRequestExchangeController {

    @Autowired
    private StudentRequestExchangeService studentRequestService;

    @PostMapping("/api/student/subject/rq/{studentExchangeRegisterId}")
    public StudentRequestExchangeDTO addRequest(@PathVariable Long studentExchangeRegisterId) {
        return studentRequestService.sendRequest(studentExchangeRegisterId);
    }

    @PutMapping("/api/student/subject/rq/")
    public ResponseEntity<?> confirmStudentResponse(
            @PathVariable Long studentRequestId,
            @PathVariable Long studentResponseId
    ) {
//        return studentRequestService.confirm(studentRequestId, studentResponseId)
//                ? ResponseEntity.ok("Success") : ResponseEntity.ok("Fail");
        return null;
    }

    @GetMapping("/api/student/subject/rq")
    public List<StudentRequestExchange> getAllRequest() {
        return studentRequestService.getAlllist();
    }

    @GetMapping("/api/student/subject/rq/user")
    public List<StudentRequestExchangeDTO> getAllRequestOfStudentCurrent() {
        return studentRequestService.getListByUsername();
    }


}
