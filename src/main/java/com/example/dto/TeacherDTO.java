package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class TeacherDTO extends PersonDTO {
    private String username;
    private Long subjectId;

}
