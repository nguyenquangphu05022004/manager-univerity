package com.example.dto;

import com.example.entity.embedded.InfoGrade;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class GradeDTO extends GenericDTO {
    private Long registerId;
    private RegisterDTO registerDTO;
    private InfoGrade infoGrade;
    private CoefficientDTO coefficient;
    private Float gpa;
    public float gpa() {
        this.gpa = coefficient.getInfoGrade().getAttend() * infoGrade.getAttend()
                + coefficient.getInfoGrade().getMidterm() * infoGrade.getMidterm()
                + coefficient.getInfoGrade().getEndOfTerm() * infoGrade.getEndOfTerm()
                + coefficient.getInfoGrade().getPractice() * infoGrade.getPractice()
                + coefficient.getInfoGrade().getTest() * infoGrade.getTest();
        return gpa;
    }



}
