package com.example.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class StudentResponseDTO {
    private Long id;
    private StudentDTO studentResponse;
    private SubjectDTO subjectResponse;
    private GroupDTO groupResponse;
    private Boolean exchange;
}
