package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.MajorDTO;
import com.example.dto.SubjectDTO;
import com.example.entity.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("majorConverter")
public class MajorConverter implements GenericConverter<Major, MajorDTO> {


    @Override
    public Major toEntity(MajorDTO dto) {
        return Major.builder()
                .name(dto.getName())
                .majorCode(dto.getMajorCode())
                .build();
    }

    @Override
    public MajorDTO toDto(Major entity) {
        return MajorDTO.builder()
                .majorCode(entity.getMajorCode())
                .name(entity.getName())
                .id(entity.getId())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

    @Override
    public Major toEntity(Major entity, MajorDTO dto) {
        return entity.toBuilder()
                .majorCode(dto.getMajorCode())
                .name(dto.getName())
                .build();
    }

    @Override
    public MajorDTO toDto(MajorDTO dto, Major entity) {
        return null;
    }

    @Override
    public List<MajorDTO> dtoList(List<Major> majors) {
        List<MajorDTO> majorDTOS = new ArrayList<>();
        majors.forEach((v) -> {
            majorDTOS.add(toDto(v));
        });
        return majorDTOS;
    }


}
