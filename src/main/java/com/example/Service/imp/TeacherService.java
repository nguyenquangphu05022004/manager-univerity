package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.TeacherConverter;
import com.example.dto.TeacherDTO;
import com.example.entity.Major;
import com.example.entity.Subject;
import com.example.entity.Teacher;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.MajorRepository;
import com.example.repository.SubjectRepository;
import com.example.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceOfTeacher")
public class TeacherService implements GenericService<TeacherDTO> {

    private TeacherConverter converter;
    private TeacherRepository teacherRepository;
    private SubjectRepository subjectRepository;
    private MajorRepository majorRepository;

    @Autowired
    public TeacherService(TeacherConverter converter,
                          TeacherRepository teacherRepository,
                          SubjectRepository subjectRepository,
                          MajorRepository majorRepository) {
        this.converter = converter;
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.majorRepository = majorRepository;
    }

    @Override
    public TeacherDTO save(TeacherDTO object) throws ResourceNotFoundException {
        Teacher teacher = new Teacher();
        Subject subject = subjectRepository.
                findOneById(object.getSubjectId())
                .orElseThrow(
                        () -> new ResourceNotFoundException
                                ("Không tìm thấy Sujbect có id: "
                                        + object.getSubjectId())
                );
        Major major = majorRepository.
                findOneByMajorCode(object.getMajorCode())
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Không tìm thấy Major có code: " +
                                object.getMajorCode()));
        if (object.getId() != null) {
            Teacher oldTeacher = teacherRepository.findOne(object.getId());
            teacher = converter.toEntity(oldTeacher, object);
        } else {
            teacher = converter.toEntity(object);
        }
        return converter.toDto(teacherRepository.save(teacher
                .toBuilder().subject(subject)
                .major(major).build()));

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

    @Override
    public TeacherDTO getById(Long id) {
        return null;
    }

    @Override
    public List<TeacherDTO> getByCode(String code) {
        return null;
    }
}
