package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.GenericConverter;
import com.example.converter.imp.StudentConverter;
import com.example.converter.imp.SubjectConverter;
import com.example.converter.imp.TeacherConverter;
import com.example.dto.MajorDTO;
import com.example.dto.StudentDTO;
import com.example.dto.SubjectDTO;
import com.example.dto.TeacherDTO;
import com.example.entity.Major;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.entity.Teacher;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("majorService")
public class MajorService implements GenericService<MajorDTO> {

    @Autowired
    private MajorRepository majorRepository;
    @Autowired
    private GenericConverter<Major, MajorDTO> converter;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentConverter studentConverter;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private TeacherConverter teacherConverter;

    @Override
    public MajorDTO save(MajorDTO object) {
        Major major = new Major();
        if (object.getId() != null) {
            Major oldMajor = majorRepository.
                    findOneById(object.getId())
                    .orElseThrow(() -> new ResourceNotFoundException
                            ("Không tìm thấy Major với mã: " +
                                    object.getId()));
            major = converter.toEntity(oldMajor, object);
        } else {
            major = converter.toEntity(object);
        }
        return converter.toDto(majorRepository.save(major));
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            majorRepository.delete(id);
        }
    }

    @Override
    public List<MajorDTO> list() {
       List<Major> listEntity = majorRepository.findAll();
       List<MajorDTO> listDto = new ArrayList<>();
       for (Major major : listEntity) {
           MajorDTO majorDTO = converter.toDto(major);
           listDto.add(majorDTO);
       }
        return listDto;
    }

    @Override
    public MajorDTO getById(Long id) {
        return converter.toDto(
                majorRepository.findOneById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException
                                ("Không tìm thấy Major với mã: " + id)
        ));
    }

    @Override
    public List<MajorDTO> getByCode(String code) {
        return null;
    }

}
