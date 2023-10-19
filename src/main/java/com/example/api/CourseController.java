package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Service.imp.CourseService;
import com.example.dto.CourseDTO;

@RestController
@CrossOrigin("*")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @PostMapping("/api/courses")
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.save(courseDTO);
    }

    @GetMapping("/api/courses")
    public List<CourseDTO> getAllCourse() {
        return courseService.list();
    }


}
