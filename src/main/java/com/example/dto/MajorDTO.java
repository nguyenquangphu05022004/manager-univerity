package com.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class MajorDTO extends GenericDTO {
    private String majorCode;
    private String name;
//    private List<StudentDTO> studentList = new ArrayList<>();
//    private List<SubjectDTO> subjects = new ArrayList<>();
//    private List<TeacherDTO> teachers = new ArrayList<>();

}
