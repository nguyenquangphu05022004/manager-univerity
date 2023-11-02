package com.example.dto;

import com.example.entity.SchoolYear;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class SemesterOfYearDTO extends GenericDTO{
    private SchoolYearDTO schoolYearDTO;
    private SemesterDTO semesterDTO;
}
