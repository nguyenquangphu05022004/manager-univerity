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


    @ManyToMany
    @JoinTable(name = "studentRequest_studentExchange_register",
            joinColumns = @JoinColumn(name = "studentRequest"),
            inverseJoinColumns = @JoinColumn(name = "studentExchange"))
    private List<StudentExchangeRegister> studentExchangeRegisters = new ArrayList<>();

    @Column(name = "statusRequest")
    private Boolean statusRequest;

    @Column(name = "statusExchange")
    private Boolean statusExchange;

}