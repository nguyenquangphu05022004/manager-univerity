package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "studentRequestExchange")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class StudentRequestExchange extends Base{

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "register_id")
    private Register register;

    @ManyToOne
    @JoinColumn(name = "studentExchangeRegisterId")
    private StudentExchangeRegister studentExchangeRegister;

    @Column(name = "statusRequest")
    private Boolean statusRequest;

    @Column(name = "statusExchange")
    private Boolean statusExchange;

}