package com.example.dto;

import com.example.entity.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class TeacherDTO extends GenericDTO {
    private PersonDTO person;
    private List<SubjectDTO> subjectDTOS = new ArrayList<>();
    private Set<Long> subjectIds = new HashSet<>();
}
