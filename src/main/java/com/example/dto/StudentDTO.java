package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class StudentDTO extends PersonDTO{
    private Long subjectId;
    private String roles;
}
