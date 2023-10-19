package com.example.api;

import com.example.Service.GenericService;
import com.example.Service.imp.MajorService;
import com.example.dto.MajorDTO;
import com.example.entity.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MajorController {

    @Autowired
    private MajorService majorService;
    @PostMapping("/api/majors")
    public MajorDTO createMajor(@RequestBody MajorDTO majorDTO) {
        return majorService.save(majorDTO);
    }
    @GetMapping("/api/majors")
    public List<MajorDTO> getListMajor() {
        return majorService.list();
    }
    
    @GetMapping("/api/majors/{id}")
    public MajorDTO getMajorById(@PathVariable Long id) {
        return majorService.getById(id);
    }
    @PutMapping("/api/majors/{id}")
    public MajorDTO updateMajor(@PathVariable Long id,@RequestBody MajorDTO majorDTO) {
        return majorService.save(majorDTO.toBuilder().id(id).build());
    }

    @DeleteMapping("/api/majors")
    public void deleteMajor(@RequestBody Long[] ids) {
        majorService.delete(ids);
    }


}
