package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studentExchangeRegister")
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
public class StudentExchangeRegister extends Base {

    @ManyToMany
    @JoinTable(name = "registerExchangeStudent",
        joinColumns = @JoinColumn(name = "studentExchangeSubjectId"),
            inverseJoinColumns = @JoinColumn(name = "registerId")
    )
    private List<Register> registers = new ArrayList<>();

    @ManyToMany(mappedBy = "studentExchangeRegisters")
    private List<StudentRequestExchange> studentRequestExchanges = new ArrayList<>();

    @Column(name = "status")
    private Boolean status;


}
