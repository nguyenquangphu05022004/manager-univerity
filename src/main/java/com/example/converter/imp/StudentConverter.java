package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentDTO;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("studentConverter")
public class StudentConverter implements GenericConverter<Student, StudentDTO> {
//    @Autowired
//    private ConverterSubjectExchange subjectExchange;
    @Autowired
    private SubjectConverter subjectConverter;
    @Override
    public Student toEntity(StudentDTO dto) {
        return Student.builder().address(dto.getAddress())
                .birthOfDate(dto.getBirthOfDate())
                .email(dto.getEmail()).fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .username(dto.getUsername())
                .password(new BCryptPasswordEncoder().encode(dto.getPassword()))
                .build();
    }
    @Override
    public StudentDTO toDto(Student entity) {
        return StudentDTO.builder().id(entity.getId())
                .address(entity.getAddress())
                .birthOfDate(entity.getBirthOfDate())
                .email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .majorCode(entity.getMajor().getMajorCode())
                .createDate(entity.getCreateDate())
                .createBy(entity.getCreateBy())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .username(entity.getUsername())
                .build();
    }

    @Override
    public Student toEntity(Student entity, StudentDTO dto) {
        return entity.toBuilder()
                .address(dto.getAddress())
                .birthOfDate(dto.getBirthOfDate())
                .email(dto.getEmail()).fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .password(new BCryptPasswordEncoder().encode(dto.getPassword()))
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
