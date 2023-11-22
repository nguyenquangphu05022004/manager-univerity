package com.example.api;

import com.example.Service.imp.RegisterService;
import com.example.dto.RegisterDTO;
import com.example.dto.RegisterOfMajorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/register-subject/{timeTableId}/{registerOfMajorId}")
    public RegisterDTO registerSubject(@PathVariable Long timeTableId,
                                       @PathVariable Long registerOfMajorId) {
        return registerService.register(timeTableId, registerOfMajorId);
    }
    @DeleteMapping("/api/register-subject/{registerId}")
    public void removeRecordRegister(@PathVariable Long registerId) {
        registerService.delete(registerId);
    }

    @GetMapping("/api/register-subject/{registerOfMajorId}")
    public List<RegisterDTO> getAllRegisterOfStudent(@PathVariable Long registerOfMajorId) {
        return registerService.getAllRecordOfStudent(registerOfMajorId);
    }

}
