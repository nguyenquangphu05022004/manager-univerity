package com.example.converter.imp;

import com.example.converter.GenericConverter;
import com.example.dto.TimeTableDTO;
import com.example.entity.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TimeTableConverter implements GenericConverter<TimeTable, TimeTableDTO> {


    @Autowired
    private ClassRoomConverter classRoomConverter;
    @Autowired
    private SubjectConverter subjectConverter;
    @Autowired
    private GroupConverter groupConverter;
    @Autowired
    private TeacherConverter teacherConverter;
    @Override
    public TimeTable toEntity(TimeTableDTO dto) {
        return TimeTable.builder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .endTime(dto.getEndTime())
                .startTime(dto.getStartTime())
                .dayOfWeek(dto.getDayOfWeek())
                .build();
    }

    @Override
    public TimeTableDTO toDto(TimeTable entity) {
        return TimeTableDTO.builder()
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .id(entity.getId())
                .dayOfWeek(entity.getDayOfWeek())
                .groupDTO(groupConverter.toDto(entity.getGroup()))
                .classRoomDTO(classRoomConverter.toDto(entity.getClassRoom()))
                .teacherDTO(teacherConverter.toDto(entity.getTeacher()))
                .subjectDTO(subjectConverter.toDto(entity.getSubject()))
                .build();
    }

    @Override
    public TimeTable toEntity(TimeTable entity, TimeTableDTO dto) {
        return entity.toBuilder()
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .dayOfWeek(dto.getDayOfWeek())
                .build();
    }

    @Override
    public TimeTableDTO toDto(TimeTableDTO dto, TimeTable entity) {
        return null;
    }

    @Override
    public List<TimeTableDTO> dtoList(List<TimeTable> entityList) {
        return entityList
                .stream()
                .map((e) -> toDto(e))
                .collect(Collectors.toList());
    }
}
