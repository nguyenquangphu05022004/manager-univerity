package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
public class RegisterOfMajorDTO extends GenericDTO{
    private MajorDTO majorDTO;
    private SchoolYearDTO schoolYearDTO;
    private List<SubjectDTO> subjects = new ArrayList<>();
    private SemesterDTO semesterDTO;

}
