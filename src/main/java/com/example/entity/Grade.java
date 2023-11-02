package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Grades")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Grade extends Base{

    @OneToOne
    @JoinColumn(name = "register_id")
    private Register register;

    @Column(columnDefinition = "float(2)")
    private Float attend;
    @Column(columnDefinition = "float(2)")
    private Float midterm;
    @Column(name = "endofterm", columnDefinition = "float(2)")
    private Float endOfTerm;
    @Column(columnDefinition = "float(2)")
    private Float test;
    @Column(columnDefinition = "float(2)")
    private Float practice;
    @Column(columnDefinition = "float(2)")
    private Float gpa;



}
