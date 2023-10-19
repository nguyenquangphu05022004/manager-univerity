package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.GradeConverter;
import com.example.dto.GradeDTO;
import com.example.entity.Grade;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.GradeRepository;
import com.example.repository.StudentRepository;
import com.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("gradeOfService")
public class GradeService implements GenericService<GradeDTO> {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private GradeConverter gradeConverter;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public GradeDTO save(GradeDTO object) {
        try {
            Grade grade = new Grade();
            Subject subject = subjectRepository.
                    findOneById(object.getSubjectId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException
                                    ("Không tìm thấy Sujbect có id: " +
                                            object.getSubjectId())
                    );
            Student student = studentRepository.
                    findOneById(object.getSubjectId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException
                                    ("Không tìm thấy Student có id: " +
                                            object.getStudentId())
                    );
            if (object.getId() != null) {
                Grade oldGrade = gradeRepository.
                        findOneById(object.getSubjectId())
                        .orElseThrow(
                                () -> new ResourceNotFoundException
                                        ("Không tìm thấy Grade có id: " + object.getId())
                        );
                grade = gradeConverter.toEntity(oldGrade, object);
            } else {
                grade = gradeConverter.toEntity(object);
            }
            grade.toBuilder()
                    .subject(subject)
                    .student(student);
            return gradeConverter.toDto(gradeRepository.save(grade));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Long[] ids) {
        for(Long id: ids) {
            gradeRepository.delete(id);
        }
    }

    @Override
    public List<GradeDTO> list() {
//        List<Grade> entityList = gradeRepository.findAll();
//        return gradeConverter.dtoList(entityList);
        return null;
    }

    @Override
    public GradeDTO getById(Long id) {
        return null;
    }

    @Override
    public List<GradeDTO> getByCode(String code) {
        return null;
    }
}
