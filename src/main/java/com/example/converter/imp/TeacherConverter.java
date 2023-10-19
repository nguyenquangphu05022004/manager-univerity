package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.StudentDTO;
import com.example.dto.TeacherDTO;
import com.example.entity.Student;
import com.example.entity.Teacher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component("teacherConverter")
public class TeacherConverter implements GenericConverter<Teacher, TeacherDTO> {
    @Override
    public Teacher toEntity(TeacherDTO dto) {
        return Teacher.builder().address(dto.getAddress())
                .birthOfDate(dto.getBirthOfDate())
                .email(dto.getEmail()).fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .username(dto.getUsername()).build();
    }

    @Override
    public TeacherDTO toDto(Teacher entity) {
        return TeacherDTO.builder().id(entity.getId())
                .address(entity.getAddress())
                .birthOfDate(entity.getBirthOfDate()).email(entity.getEmail())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .majorCode(entity.getMajor().getMajorCode())
                .majorId(entity.getMajor().getId())
                .createDate(entity.getCreateDate())
                .createBy(entity.getCreateBy()).modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .username(entity.getUsername()).build();
    }

    @Override
    public Teacher toEntity(Teacher entity, TeacherDTO dto) {
        return entity.toBuilder()
                .address(dto.getAddress())
                .birthOfDate(dto.getBirthOfDate())
                .email(dto.getEmail()).fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber()).build();
    }

    @Override
    public TeacherDTO toDto(TeacherDTO dto, Teacher entity) {
        return null;
    }

//    @Override
//    public List<TeacherDTO> dtoList(Set<Teacher> entityList) {
//        return null;
//    }

    @Override
    public List<TeacherDTO> dtoList(List<Teacher> entityList) {
        List<TeacherDTO> dtolist = new ArrayList<>();
        for (Teacher entity : entityList) {
            dtolist.add(toDto(entity));
        }
        return dtolist;
    }


}
