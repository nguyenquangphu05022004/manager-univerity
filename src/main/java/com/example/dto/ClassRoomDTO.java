package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ClassRoomDTO extends GenericDTO {
    private String classRoomCode;
    private String roomName;
    private String house;
    private Integer studentQuantity;
    private Timestamp dateTime;
    private Long subjectId;
    private List<StudentDTO> students = new ArrayList<>();

}
