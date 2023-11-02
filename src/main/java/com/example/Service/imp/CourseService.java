package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.CourseConverter;
import com.example.dto.CourseDTO;
import com.example.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements GenericService<CourseDTO> {

    @Autowired
    private CourseConverter courseConverter;
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void delete(Long[] ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<CourseDTO> getByCode(String code) {
        // TODO Auto-generated method stub
        return null;

    }

    @Override
    public CourseDTO getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CourseDTO> list() {
       return courseConverter.dtoList(courseRepository.findAll());
    }

    @Override
    public CourseDTO save(CourseDTO object) {
        return courseConverter
                .toDto(courseRepository
                        .save(courseConverter
                                .toEntity(object)));
    }

}
