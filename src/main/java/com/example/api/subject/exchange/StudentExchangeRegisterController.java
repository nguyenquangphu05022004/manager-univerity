package com.example.api.subject.exchange;

import com.example.Service.imp.StudentExchangeRegisterService;
import com.example.dto.StudentExchangeRegisterDTO;
import com.example.entity.StudentExchangeRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentExchangeRegisterController {

    @Autowired
    private StudentExchangeRegisterService studentExchangeRegisterService;

    @PostMapping("/api/student/subject/ex/{registerId}")
    public StudentExchangeRegisterDTO addResponse(@PathVariable Long registerId) {
        return studentExchangeRegisterService.exchangeRegister(registerId);
    }

    @GetMapping("/api/student/subject/ex/{registerOfMajor}")
    public List<StudentExchangeRegisterDTO> getListExchangeOfStudent(@PathVariable Long registerOfMajor) {
        return studentExchangeRegisterService.getListExchangeByRegisterOfMajorId(registerOfMajor);
    }

}