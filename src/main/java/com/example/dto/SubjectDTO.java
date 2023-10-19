package com.example.dto;

import com.example.entity.Grade;
import com.example.entity.Major;
import com.example.entity.Student;
import com.example.entity.Teacher;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class SubjectDTO extends GenericDTO implements Comparable<SubjectDTO> {
    private String subjectName;
    private String subjectCode;
    private Date startDate;
    private Date endDate;
    private Integer credit;
    private Set<String> majorCode = new LinkedHashSet<>();
    private List<Long> groupId = new ArrayList<>();
    private List<String> groupCode = new ArrayList<>();


    @Override
    public int compareTo(SubjectDTO o) {
        return this.subjectName.compareTo(o.getSubjectName());
    }
}
