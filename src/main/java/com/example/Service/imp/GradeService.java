package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.GradeConverter;
import com.example.dto.GradeDTO;
import com.example.entity.Grade;
import com.example.entity.Register;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("gradeOfService")
public class GradeService implements GenericService<GradeDTO> {

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private GradeConverter gradeConverter;

    @Autowired
    private GenericSearchBy searchBy;

    @Override
    public GradeDTO save(GradeDTO object) {
        Grade grade = null;
        if (object.getId() != null) {
            Grade oldGrade = searchBy.findGradeById(object.getId());
            grade = gradeConverter.toEntity(oldGrade, object);
        } else {
            grade = gradeConverter.toEntity(object);
        }
        Register register = searchBy.findRegisterById(object.getRegisterId());
        grade = grade.toBuilder()
                .register(register)
                .build();
//        if(register.getStudent()
//                .getUsername()
//                .compareTo(SecurityContextHolder
//                        .getContext()
//                        .getAuthentication()
//                        .getName()) == 0) {
//            return gradeConverter.toDto(gradeRepository.save(grade));
//        } else {
//            throw new ResourceNotFoundException("Mã RegisterId: " + object.getId());
//        }
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            gradeRepository.delete(id);
        }
    }

    @Override
    public List<GradeDTO> list() {
        // List<Grade> entityList = gradeRepository.findAll();
        // return gradeConverter.dtoList(entityList);
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
