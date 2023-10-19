package com.example.api;

import com.example.Service.imp.RegisterSubjectService;
import com.example.dto.RegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RegisterSubjectController {
    @Autowired
    private RegisterSubjectService registerSubjectService;

    @PostMapping("/api/register-subject/{subjectId}/{groupId}")
    public RegisterDTO registerSubject(@PathVariable Long subjectId,
                                       @PathVariable Long groupId) {
        return registerSubjectService.register(subjectId, groupId);
    }
    @DeleteMapping("/api/register-subject/{registerId}")
    public void removeRecordRegister(@PathVariable Long registerId) {
        registerSubjectService.delete(registerId);
    }

    @GetMapping("/api/register-subject")
    public List<RegisterDTO> getAllRegisterOfStudent() {
        return registerSubjectService.getAllRecordOfStudent();
    }


}
