package com.example.api;

import com.example.Service.imp.SemesterService;
import com.example.dto.SemesterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SemesterController {
    @Autowired
    private SemesterService semesterService;
    @PostMapping("/api/semesters")
    public SemesterDTO createSemester(@RequestBody SemesterDTO semesterDTO) {
        return semesterService.save(semesterDTO);
    }
}
