package com.example.api;

import com.example.Service.imp.RegisterOfMajorService;
import com.example.dto.RegisterOfMajorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RegisterOfMajorController {

    @Autowired
    private RegisterOfMajorService registerOfMajorService;

    @PostMapping("/api/subject/major")
    public RegisterOfMajorDTO registerSubjectForMajor(@RequestBody RegisterOfMajorDTO registerOfMajorDTO) {
        return registerOfMajorService.save(registerOfMajorDTO);
    }

    @GetMapping("/api/subject/major/{registerOfMajorId}")
    public RegisterOfMajorDTO getRegisterOfMajorById(
            @PathVariable Long registerOfMajorId) {
        return registerOfMajorService.getById(registerOfMajorId);
    }
}
