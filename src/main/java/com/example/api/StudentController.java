package com.example.api;

import com.example.Service.GenericService;
import com.example.Service.imp.StudentService;
import com.example.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/api/students")
    public List<StudentDTO> showStudent() {
        return studentService.list();
    }

    @PostMapping("/api/students")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }
    @PutMapping("/api/students/{id}")
    public StudentDTO updateStudent(@PathVariable(name = "id")Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO.toBuilder().id(id).build());

    }
    @DeleteMapping("/api/students")
    public void deleteStudent(@RequestBody Long[] ids) {
        studentService.delete(ids);
    }

    @GetMapping("/api/students/{id}")
    public StudentDTO getStudentById(@PathVariable Long id) {
        return studentService.getById(id);
    }

}
