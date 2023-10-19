package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student_request")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
@NamedStoredProcedureQuery(name = "confirmResponse",
    procedureName = "usp_ConfirmResponse",
        parameters = {
            @StoredProcedureParameter(name = "studentRequestId", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "studentResponseId", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "result", mode = ParameterMode.OUT, type = Boolean.class)
        }
)
public class StudentRequest extends Base {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentRequest;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectRequest;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupRequest;

    @ManyToMany(mappedBy = "studentRequests")
    private List<StudentResponse> studentResponses = new ArrayList<>();
    @Column(name = "status")
    private Boolean status;
    @Column(name = "exchange")
    private Boolean exchange;

}
