package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class SubjectDTO extends GenericDTO implements Comparable<SubjectDTO> {
    private String subjectName;
    private String subjectCode;
    private Integer credit;
    private String nameCollectSubject;
    private Set<String> majorCode = new LinkedHashSet<>();
    private List<Long> groupId = new ArrayList<>();
    private List<String> groupCode = new ArrayList<>();
    private List<TimeTableDTO> timeTableDTOS = new ArrayList<>();

    @Override
    public int compareTo(SubjectDTO o) {
        return this.subjectName.compareTo(o.getSubjectName());
    }
}
