package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

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

//    @ManyToMany
//    @JoinTable(name = "studentExchangeRegisterRegister",
//        joinColumns = @JoinColumn(name = "studentExchangeSubjectId"),
//            inverseJoinColumns = @JoinColumn(name = "registerId")
//    )
//    private List<Register> registers = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "register_iD")
    private  Register register;

    @OneToMany(mappedBy = "studentExchangeRegister")
    private List<StudentRequestExchange> studentRequestExchanges = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "statusExchange") //TODO: ĐÂY LÀ TRẠNG THÁI KHI MÔN HỌC ĐÃ ĐƯỢC TRAO ĐỔI
    private Boolean statusExchange;

    @Column(name = "statusRequest")
    private Boolean statusRequest; //TODO: ĐÂY LÀ STATUS TRẠNG THÁI ĐÃ GỬI REQUEST TRAO ĐỔI


}
