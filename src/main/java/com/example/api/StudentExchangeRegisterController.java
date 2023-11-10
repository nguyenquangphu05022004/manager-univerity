package com.example.api;

import com.example.Service.imp.StudentExchangeRegisterService;
import com.example.dto.StudentExchangeRegisterDTO;
import com.example.dto.StudentRequestExchangeDTO;
import com.example.entity.StudentExchangeRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentExchangeRegisterController {

    @Autowired
    private StudentExchangeRegisterService studentExchangeRegisterService;

    @PostMapping("/api/student/subject/ex/{registerId}")
    public ResponseEntity<?> addResponse(@PathVariable Long registerId) {
         StudentExchangeRegisterDTO exchangeRegisterDTO =
                 studentExchangeRegisterService
                         .exchangeRegister(registerId);
         return exchangeRegisterDTO != null ? ResponseEntity.ok(exchangeRegisterDTO)
                 : ResponseEntity.ok("Mã RegisterId: " + registerId + " bạn chưa có!");
    }

    @GetMapping("/api/student/subject/ex/{registerOfMajor}")
    public List<StudentExchangeRegisterDTO> getListExchangeOfStudent(@PathVariable Long registerOfMajor) {
        return studentExchangeRegisterService.getListExchangeByRegisterOfMajorId(registerOfMajor);
    }


}