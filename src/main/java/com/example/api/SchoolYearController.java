package com.example.api;

import com.example.Service.imp.SchoolYearService;
import com.example.dto.SchoolYearDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class SchoolYearController {
    @Autowired
    private SchoolYearService schoolYearService;
    @PostMapping("/api/school/years")
    public SchoolYearDTO createSchoolYear(@RequestBody SchoolYearDTO schoolYearDTO) {
        return schoolYearService.save(schoolYearDTO);
    }
    @GetMapping("/api/school/years")
    public List<SchoolYearDTO> getAllSchoolYear() {
        return schoolYearService.list();
    }
}
