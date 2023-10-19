package com.example.api;

import com.example.Service.GenericService;
import com.example.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")

public class TeacherController {

    @Autowired
    private GenericService<TeacherDTO> teacherService;


    @GetMapping("/api/teachers")
    public List<TeacherDTO> showList() {
        return teacherService.list();
    }
    @PostMapping("/api/teachers")
    public TeacherDTO addTeacher(@RequestBody TeacherDTO teacherDTO) {
        return teacherService.save(teacherDTO);
    }
    @PutMapping("/api/teachers/{id}")
    public TeacherDTO updateTeacher(@PathVariable Long id, @RequestBody TeacherDTO teacherDTO) {
        return teacherService.save(teacherDTO.toBuilder().id(id).build());
    }
    @DeleteMapping("/api/teachers")
    public void deleteTeacher(@RequestBody Long[] ids) {
        teacherService.delete(ids);
    }

}
