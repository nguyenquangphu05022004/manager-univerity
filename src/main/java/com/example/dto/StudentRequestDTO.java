package com.example.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentRequestDTO {
    private Long id;
    private StudentDTO studentDTO ;
    private SubjectDTO subjectDTO;
    private GroupDTO groupDTO;
    private Boolean exchange;
}
