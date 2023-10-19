package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.SemesterConverter;
import com.example.dto.SemesterDTO;
import com.example.entity.Semester;
import com.example.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SemesterService implements GenericService<SemesterDTO> {
    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private SemesterConverter semesterConverter;
    @Override
    public SemesterDTO save(SemesterDTO object) {
        Semester semester = Semester
                            .builder()
                            .semester(object.getSemesterEnum())
                            .build();
        return semesterConverter
                .toDto(semesterRepository.save(semester));
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<SemesterDTO> list() {
        return null;
    }

    @Override
    public SemesterDTO getById(Long id) {
        return null;
    }

    @Override
    public List<SemesterDTO> getByCode(String code) {
        return null;
    }
}
