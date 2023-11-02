package com.example.dto;

import com.example.entity.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class RegisterDTO extends GenericDTO{
    private Long studentId;
    private Boolean status;
    private SubjectDTO subjectDTO;
    private Long registerOfMajorId;
}
