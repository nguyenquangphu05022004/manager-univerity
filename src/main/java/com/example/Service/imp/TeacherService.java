package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.PersonConverter;
import com.example.converter.imp.TeacherConverter;
import com.example.dto.TeacherDTO;
import com.example.entity.Person;
import com.example.entity.Subject;
import com.example.entity.Teacher;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("serviceOfTeacher")
public class TeacherService implements GenericService<TeacherDTO> {

    private TeacherConverter converter;
    private TeacherRepository teacherRepository;
    private PersonConverter personConverter;
    private PersonService personService;
    private GenericSearchBy searchBy;
    @Autowired
    public TeacherService(TeacherConverter converter,
                          TeacherRepository teacherRepository,
                          PersonConverter personConverter,
                          PersonService personService,
                          GenericSearchBy searchBy) {
        this.converter = converter;
        this.teacherRepository = teacherRepository;
        this.personConverter = personConverter;
        this.personService = personService;
        this.searchBy = searchBy;
    }

    @Override
    public TeacherDTO save(TeacherDTO object) {
        Person person = personConverter.toEntity(personService.save(object.getPerson()));
        List<Subject> subjects = object.getSubjectIds()
                .stream()
                .map((id) -> searchBy.findBySubjectId(id))
                .collect(Collectors.toList());
        Teacher teacher = null;
        if(object.getId() != null) {
            Teacher oldTeacher = searchBy.findTeacherById(object.getId());
            teacher = converter.toEntity(oldTeacher, object);
        } else {
            teacher = converter.toEntity(object);
        }
        teacher = teacher
                .toBuilder()
                .person(person)
                .subjects(subjects)
                .build();
        return teacher != null ? converter.toDto(teacherRepository.save(teacher)) : null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            teacherRepository.delete(id);
        }
    }

    @Override
    public List<TeacherDTO> list() {
//        List<Teacher> entityList = teacherRepository.findAll();
//        return converter.dtoList(entityList);
        return null;
    }

   
}
