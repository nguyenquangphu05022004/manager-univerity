package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.RegisterOfMajorConverter;
import com.example.dto.RegisterOfMajorDTO;
import com.example.dto.SubjectDTO;
import com.example.entity.*;
import com.example.repository.RegisterOfMajorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegisterOfMajorService implements GenericService<RegisterOfMajorDTO> {
    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private RegisterOfMajorConverter registerOfMajorConverter;
    @Autowired
    private RegisterOfMajorRepository registerOfMajorRepository;
    @Override
    public RegisterOfMajorDTO save(RegisterOfMajorDTO object) {
        Semester semester = searchBy.findSemesterById(object.getSemesterDTO().getId());
        SchoolYear schoolYear = searchBy.findSchoolYearById(object.getSchoolYearDTO().getId());
        List<SchoolYear> schoolYears = new ArrayList<>(); schoolYears.add(schoolYear);
        Major major = searchBy.findMajorById(object.getMajorDTO().getId());
        Set<Subject> subjects = new HashSet<>();
        object.getSubjects().forEach((s) -> {
            subjects.add(searchBy.findBySubjectId(s.getId()));
        });
        RegisterOfMajor registerOfMajor = RegisterOfMajor.builder()
                .major(major)
                .schoolYears(schoolYears)
                .semester(semester)
                .subjects(subjects.stream().collect(Collectors.toList()))
                .build();
        return registerOfMajorConverter
                .toDto(registerOfMajorRepository
                        .save(registerOfMajor));
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<RegisterOfMajorDTO> list() {
        return null;
    }


    @Override
    public RegisterOfMajorDTO getById(Long id) {
        return null;
    }

    @Override
    public List<RegisterOfMajorDTO> getByCode(String code) {
        return null;
    }

    public List<RegisterOfMajorDTO> getListByMajorId(Long majorId) {
        return registerOfMajorConverter
                .dtoList(searchBy
                        .findMajorById(majorId)
                        .getRegisterOfMajors());
    }
}