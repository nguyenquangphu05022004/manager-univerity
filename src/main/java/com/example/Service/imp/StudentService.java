package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.IGenericServiceExpand;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.PersonConverter;
import com.example.converter.imp.StudentConverter;
import com.example.dto.StudentDTO;
import com.example.entity.*;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("studentOfService")
public class StudentService implements GenericService<StudentDTO>, IGenericServiceExpand<StudentDTO> {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentConverter converter;
    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private PersonConverter personConverter;
    @Autowired
    private PersonService personService;


    @Transactional
    @Override
    public StudentDTO save(StudentDTO object) {
        Person person = personConverter.toEntity(personService.save(object.getPersonDTO()));
        Course course = searchBy.findCourseById(object.getCourseDTO().getId());
        Student student = null;
        if (object.getId() != null) {
            Student oldStudent = searchBy.findStudentById(object.getId());
            student = converter
                    .toEntity(oldStudent, object)
                    .toBuilder()
                    .person(person)
                    .course(course)
                    .build();
        } else {
            student = Student
                    .builder()
                    .person(person)
                    .course(course)
                    .build();
        }
        return converter.toDto(studentRepository.save(student));
        // TODO: 8/24/2023
    }


    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            studentRepository.delete(id);
        }
        // TODO: 8/24/2023
    }

    @Override
    public List<StudentDTO> list() {
        List<Student> entityList = studentRepository.findAll();
        List<StudentDTO> dtoList = new ArrayList<>();
        for (Student entityStudent : entityList) {
            dtoList.add(converter.toDto(entityStudent));
        }
        return dtoList;
        // TODO: 8/24/2023
    }


    @Override
    public StudentDTO getById(Long id) {
        return converter.toDto(searchBy.findStudentById(id));
    }
}

