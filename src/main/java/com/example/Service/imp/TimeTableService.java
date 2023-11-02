package com.example.Service.imp;

import com.example.Service.GenericService;
import com.example.converter.imp.ClassRoomConverter;
import com.example.converter.imp.TimeTableConverter;
import com.example.dto.TimeTableDTO;
import com.example.entity.*;
import com.example.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableService implements GenericService<TimeTableDTO> {

    @Autowired
    private TimeTableRepository timeTableRepository;
    @Autowired
    private TimeTableConverter timeTableConverter;
    @Autowired
    private GenericSearchBy searchBy;
    @Autowired
    private ClassRoomConverter classRoomConverter;

    @Override
    public TimeTableDTO save(TimeTableDTO object) {
        TimeTable timeTable = null;
        Subject subject = searchBy.findBySubjectId(object.getSubjectDTO().getId());
        Group group = searchBy.findByIdGroup(object.getGroupDTO().getId());
        Teacher teacher = searchBy.findTeacherById(object.getTeacherDTO().getId());
        ClassRoom classRoom = searchBy.findClassRoomById(object.getClassRoomDTO().getId());
        if (object.getId() != null) {
            TimeTable oldTimeTable = searchBy.findTimeTableById(object.getId());
            timeTable = timeTableConverter.toEntity(oldTimeTable, object);
        } else {
            timeTable = timeTableConverter.toEntity(object);
        }
        timeTable = timeTable.toBuilder()
                .subject(subject)
                .group(group)
                .classRoom(classRoom)
                .teacher(teacher)
                .build();
        return timeTableConverter.toDto(timeTableRepository.save(timeTable));
    }

    @Override
    public void delete(Long[] ids) {

    }

    @Override
    public List<TimeTableDTO> list() {
//        List<TimeTable> list = timeTableRepository
//                .findAllBySubjectFromMajorId(
//                        searchBy.findStudentByUsername(SecurityContextHolder
//                                .getContext()
//                                .getAuthentication()
//                                .getName())
//                                .getMajor()
//                                .getId()
//                );
//        return timeTableConverter.dtoList(list);
        return null;
    }

    @Override
    public TimeTableDTO getById(Long id) {
        return null;
    }

    @Override
    public List<TimeTableDTO> getByCode(String code) {
        return null;
    }
}
