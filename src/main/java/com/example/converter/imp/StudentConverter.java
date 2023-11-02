package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentDTO;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("studentConverter")
public class StudentConverter implements GenericConverter<Student, StudentDTO> {
    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private CourseConverter courseConverter;
    @Override
    public Student toEntity(StudentDTO dto) {
        return  null;
    }

    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO
                .builder()
                .id(entity.getId())
                .personDTO(personConverter.toDto(entity.getPerson()))
                .courseDTO(courseConverter.toDto(entity.getCourse()))
                .build();
    }

    @Override
    public Student toEntity(Student entity, StudentDTO dto) {
        return entity.toBuilder()
                .person(personConverter.toEntity(dto.getPersonDTO()))
                .build();
    }

    @Override
    public StudentDTO toDto(StudentDTO dto, Student entity) {
        return null;
    }

    @Override
    public List<StudentDTO> dtoList(List<Student> entityList) {
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student entity : entityList) {
            dtoList.add(toDto(entity));
        }
        return dtoList;
    }


}
