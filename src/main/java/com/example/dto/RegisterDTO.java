package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class RegisterDTO extends GenericDTO{
    private StudentDTO studentDTO;
    private SubjectDTO subjectDTO;
    private GroupDTO groupDTO;
    private Boolean status;
}
