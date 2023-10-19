package com.example.api;

import com.example.Service.imp.GradeService;
import com.example.dto.GradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @PostMapping("/api/grades")
    public GradeDTO createGrade(@RequestBody GradeDTO gradeDTO) {
        return gradeService.save(gradeDTO);
    }

    @PutMapping("/api/grades/{id}")
    public GradeDTO updateGrade(@PathVariable Long id,
                               @RequestBody GradeDTO gradeDTO) {
        return gradeService.save(gradeDTO.toBuilder().id(id).build());
    }

    @DeleteMapping("/api/grades")
    public void uptaeGrade(@RequestBody Long[] ids) {
         gradeService.delete(ids);
    }

    @GetMapping("/api/grades")
    public List<GradeDTO> getListGrade() {
        return gradeService.list();
    }


}
