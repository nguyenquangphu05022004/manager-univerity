package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "subjects")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "Subject.usp_CheckSubjectIdIsEmptyInRegister",
        procedureName = "usp_CheckSubjectIdIsEmptyInRegister",
        parameters = {
                @StoredProcedureParameter(name = "subjectId", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "username", mode = ParameterMode.IN, type = String.class),
                @StoredProcedureParameter(name = "result", mode = ParameterMode.OUT, type = Boolean.class)
        }
)
public class Subject extends Base{
    @Column(name = "subjectname", columnDefinition = "nvarchar(60)")
    private String subjectName;
    @Column(name = "subjectCode", columnDefinition = "varchar(30)", unique = true)
    @NotNull
    private String subjectCode;

    @Column
    private Integer credit;

    @Column(name =  "startdate", columnDefinition = "DATETIME")
    private Date startDate;
    @Column(name = "enddate", columnDefinition = "DATETIME")
    private Date endDate;

    @ManyToMany
    @JoinTable(name = "subject_group",
        joinColumns = @JoinColumn(name = "subject_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @NotNull
    private Set<Group> groups = new LinkedHashSet<>();


    @OneToMany(mappedBy = "subjectRequest")
    private List<StudentRequest> subjectRequests = new ArrayList<>();
    @OneToMany(mappedBy = "subjectResponse")
    private List<StudentResponse> subjectResponses = new ArrayList<>();


    @OneToMany(mappedBy = "subject")
    private List<Grade> subjectOfGrades = new ArrayList<>();

    @OneToMany(mappedBy = "subject")
    private List<Register> registers = new ArrayList<>();

    @OneToMany(mappedBy = "subject")
    private List<Teacher> teachers = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "subject_major",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "major_id",
            nullable = false)
    )
    private Set<Major> majors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "subject")
    private List<ClassRoom> classRooms = new ArrayList<>();

    @ManyToMany(mappedBy = "subjects")
    private List<RegisterOfMajor> registerOfMajors = new ArrayList<>();


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Subject) {
            Subject subject = (Subject)obj;
            if(subject.subjectCode.compareTo(subjectCode) == 0) {
                return true;
            }
        }
        return false;
    }
}

