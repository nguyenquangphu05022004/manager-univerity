package com.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class GroupDTO extends GenericDTO {
    private String code;
    private List<SubjectDTO> subjectDTOS;


}
