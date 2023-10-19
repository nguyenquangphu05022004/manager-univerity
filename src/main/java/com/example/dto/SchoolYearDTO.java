package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
public class SchoolYearDTO extends GenericDTO{
    private String schoolYear;
    private Long courseId;
    private String courseCode;
    private List<RegisterOfMajorDTO> registers = new ArrayList<>();
    private List<SemesterDTO> semesters = new ArrayList<>();
}
