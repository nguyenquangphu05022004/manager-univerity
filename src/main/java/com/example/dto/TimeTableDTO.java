package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Time;

@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class TimeTableDTO extends GenericDTO{

    private SubjectDTO subjectDTO;
    private GroupDTO groupDTO;
    private ClassRoomDTO classRoomDTO;
    private TeacherDTO teacherDTO;
    private Integer dayOfWeek;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
}
