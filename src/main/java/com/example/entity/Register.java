package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "register")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
public class Register extends Base{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "timeTableId")
    private TimeTable timeTable;

    @ManyToOne
    @JoinColumn(name = "registerOfMajorId")
    private RegisterOfMajor registerOfMajor;

    @OneToOne(mappedBy = "register")
    private Grade grade;

    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "register")
    private List<StudentExchangeRegister> studentExchangeRegisters;

    @OneToMany(mappedBy = "register")
    private List<StudentRequestExchange> studentRequestExchanges;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Register) {
            Register register = (Register)obj;
            if(register.getId() == getId()) {
                return true;
            }
        }
        return false;
    }
}
