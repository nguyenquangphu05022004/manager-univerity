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
public class Subject extends Base {
    @Column(name = "subjectname", columnDefinition = "nvarchar(60)")
    private String subjectName;
    @Column(name = "subjectCode", columnDefinition = "varchar(30)", unique = true)
    @NotNull
    private String subjectCode;

    @Column
    private Integer credit;

    @Column(name = "namecollectsubject")
    private String nameCollectSubject;

    @OneToMany(mappedBy = "subject")
    private Set<TimeTable> timeTables = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "subject_major",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "major_id",
                    nullable = false)
    )
    private Set<Major> majors = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "subjects")
    private List<RegisterOfMajor> registerOfMajors = new ArrayList<>();

    @ManyToMany(mappedBy = "subjects")
    private List<Teacher> teachers = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Subject) {
            Subject subject = (Subject) obj;
            if (subject.getId().compareTo(getId()) == 0) {
                return true;
            }
        }
        return false;
    }
}

