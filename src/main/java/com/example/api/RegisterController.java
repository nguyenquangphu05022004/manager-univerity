package com.example.api;

import com.example.Service.imp.RegisterService;
import com.example.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    @PostMapping("/api/register-subject/{subjectId}/{registerOfMajorId}")
    public RegisterDTO registerSubject(@PathVariable Long subjectId,
                                       @PathVariable Long registerOfMajorId) {
        return registerService.register(subjectId, registerOfMajorId);
    }
    @DeleteMapping("/api/register-subject/{registerId}")
    public void removeRecordRegister(@PathVariable Long registerId) {
        registerService.delete(registerId);
    }

    @GetMapping("/api/register-subject")
    public List<RegisterDTO> getAllRegisterOfStudent() {
        return registerService.getAllRecordOfStudent();
    }

    @GetMapping("/api/register-subject/user")
    public List<RegisterDTO> getAllByUserCurrent() {
        return registerService.getAllRecordOfStudent();
    }


}
