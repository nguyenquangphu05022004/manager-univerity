package com.example.converter.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.dto.CourseDTO;
import com.example.entity.Course;

@Component
public class CourseConverter implements com.example.converter.GenericConverter<Course, CourseDTO> {

    @Override
    public List<CourseDTO> dtoList(List<Course> entityList) {
        return entityList.stream().map((entity) -> toDto(entity)).collect(Collectors.toList());
        
    }

    @Override
    public CourseDTO toDto(Course entity) {
        return CourseDTO.builder()
            .code(entity.getCode())
            .course(entity.getCourse())
            .id(entity.getId())
            .build();
    }

    @Override
    public CourseDTO toDto(CourseDTO dto, Course entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Course toEntity(CourseDTO dto) {

        return Course.builder()
                .course(dto.getCourse())
                .code(dto.getCode()).build();
    }

    @Override
    public Course toEntity(Course entity, CourseDTO dto) {
        return null;
    }

}
