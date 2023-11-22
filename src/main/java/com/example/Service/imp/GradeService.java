package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.Service.imp.search.GenericSearchBy;
import com.example.converter.imp.GradeConverter;
import com.example.dto.GradeDTO;
import com.example.entity.Grade;
import com.example.entity.Register;
import com.example.repository.GradeRepository;
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
        return gradeConverter.dtoList(gradeRepository.findAll());
    }
    public List<GradeDTO> list(Long registerOfMajorId) {
        return gradeConverter.dtoList(gradeRepository.findAllByRegisterRegisterOfMajorId(registerOfMajorId));
    }

    

}
