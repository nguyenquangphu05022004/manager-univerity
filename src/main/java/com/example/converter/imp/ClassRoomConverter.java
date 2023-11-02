package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.ClassRoomDTO;
import com.example.entity.ClassRoom;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("roomConverter")
public class ClassRoomConverter implements GenericConverter<ClassRoom, ClassRoomDTO> {
    @Override
    public ClassRoom toEntity(ClassRoomDTO dto) {
        return ClassRoom.builder()
                .house(dto.getHouse())
                .roomName(dto.getRoomName())
                .studentQuantity(dto.getStudentQuantity())
                .build();
    }

    @Override
    public ClassRoomDTO toDto(ClassRoom entity) {
        return ClassRoomDTO.builder()
                .id(entity.getId())
                .house(entity.getHouse()).roomName(entity.getRoomName())
                .studentQuantity(entity.getStudentQuantity())
                .createBy(entity.getCreateBy())
                .createDate(entity.getCreateDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }

    @Override
    public ClassRoom toEntity(ClassRoom entity, ClassRoomDTO dto) {

        return entity.toBuilder()
                .house(dto.getHouse())
                .studentQuantity(dto.getStudentQuantity())
                .roomName(dto.getRoomName())
                .build();
    }

    @Override
    public ClassRoomDTO toDto(ClassRoomDTO dto, ClassRoom entity) {
        return null;
    }

    @Override
    public List<ClassRoomDTO> dtoList(List<ClassRoom> entityList) {
        List<ClassRoomDTO> classRoomDTOS = new ArrayList<>();
        entityList.forEach((e) -> classRoomDTOS.add(toDto(e)));
        return classRoomDTOS;
    }


}
