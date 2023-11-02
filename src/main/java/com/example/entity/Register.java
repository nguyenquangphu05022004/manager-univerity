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
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "registerOfMajorId")
    private RegisterOfMajor registerOfMajor;

    @OneToOne(mappedBy = "register")
    private Grade grade;

    @Column(name = "status")
    private Boolean status;

    @ManyToMany(mappedBy = "registers")
    private List<StudentExchangeRegister> studentExchangeRegisters = new ArrayList<>();
}
