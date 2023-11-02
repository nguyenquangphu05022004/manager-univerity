package com.example.api;

import com.example.Service.imp.SubjectService;
import com.example.dto.SubjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@CrossOrigin("*")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/api/subjects")
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.save(subjectDTO);
    }


    @DeleteMapping("/api/subjects/")
    public void deleteSubject(Long[] ids) {
        subjectService.delete(ids);
    }

    @GetMapping("/api/subjects")
    public List<SubjectDTO> getSubjectList() {
        List<SubjectDTO> list = subjectService.list();
        Collections.sort(list);
        return list;
    }
    @GetMapping("/api/subjects/{id}")
    public SubjectDTO getSubjectById(@PathVariable("id") Long id) {
        return subjectService.getById(id);
    }

    @PutMapping("/api/subjects/{id}")
    public SubjectDTO updateSubject(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO) {
        return subjectService.save(subjectDTO.toBuilder().id(id).build());
    }

    @GetMapping("/api/subjects/re")
    public List<SubjectDTO> getSubjectByRegisterOfMajor() {
        return subjectService.getAllByRegisterOfMajorByMajorCurrent();
    }

    @GetMapping("/api/subjects/major/{majorId}")
    public List<SubjectDTO> getSubjectByMajorId(@PathVariable("majorId") Long majorId) {
        return subjectService.getAllByMajorId(majorId);
    }

    @GetMapping("/api/subjects/{majorId}/{schoolYearId}/{courseId}/{semesterId}")
    public List<SubjectDTO> getSubjectByAbovePath(
            @PathVariable("majorId") Long majorId,
            @PathVariable("schoolYearId") Long schoolYear,
            @PathVariable("courseId") Long courseId,
            @PathVariable("semesterId") Long semesterId) {
        return subjectService
                .getAllByMajorIdAndSchoolYearIdAndCourseIdAndSemesterId
                (majorId, schoolYear, courseId, semesterId);
    }


}


