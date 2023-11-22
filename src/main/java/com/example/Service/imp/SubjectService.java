package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.IGenericServiceExpand;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.SubjectConverter;
import com.example.dto.SubjectDTO;
import com.example.entity.Subject;

import com.example.entity.Tuition;
import com.example.repository.SubjectRepository;
import com.example.repository.TuitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("serviceOfSubject")
public class SubjectService implements GenericService<SubjectDTO>, IGenericServiceExpand<SubjectDTO> {

    private SubjectConverter converter;
    private SubjectRepository subjectRepository;
    private GenericSearchBy genericSearchBy;

    @Autowired
    public SubjectService(SubjectConverter converter,
                          SubjectRepository subjectRepository,
                          GenericSearchBy genericSearchBy) {
        this.converter = converter;
        this.subjectRepository = subjectRepository;
        this.genericSearchBy = genericSearchBy;
    }

    @Override
    public SubjectDTO save(SubjectDTO object) {
        Subject subject = new Subject();
        if (object.getId() != null) {
            Subject oldSubject = genericSearchBy.findBySubjectId(object.getId());
            subject = converter.toEntity(oldSubject, object);
        } else {
            subject = converter.toEntity(object);
        }
        for (String code : object.getMajorCode()) {
            subject.getMajors().add(genericSearchBy.findByCodeMajor(code));
        }
        return converter.toDto(object, subjectRepository.save(subject));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            subjectRepository.delete(id);
        }
    }

    @Override
    public List<SubjectDTO> list() {
        List<Subject> entityList = subjectRepository.findAll();
        List<SubjectDTO> dtolist = new ArrayList<>();
        for (Subject entity : entityList) {
            dtolist.add(converter.toDto(entity));
        }
        return dtolist;
    }


    public List<SubjectDTO> getAllByMajorId(Long majorId) {
        return converter.dtoList(genericSearchBy.findAllSubjectByMajorId(majorId));
    }

    public List<SubjectDTO> getAllByRegisterOfMajorByMajorCurrent() {
//        Student student = genericSearchBy
//                .findStudentByUsername(SecurityContextHolder
//                        .getContext()
//                        .getAuthentication()
//                        .getName());
//        return converter.dtoList(genericSearchBy
//                .findAllSubjectByMajorIdOfRegisterOfMajor(
//                        student.getMajor().getId()));
        return null;
    }

    public List<SubjectDTO> getAllByMajorIdAndSchoolYearIdAndCourseIdAndSemesterId(Long majorId, Long schoolYearId, Long courseId, Long semesterId) {
        return converter.dtoList
                (subjectRepository
                        .findAllByMajorIdAndSchoolYearIdAndCourseIdAndSemesterId
                                (majorId, schoolYearId, courseId, semesterId));
    }

    @Override
    public SubjectDTO getById(Long id) {
        return converter.toDto(genericSearchBy.findBySubjectId(id));
    }
}
