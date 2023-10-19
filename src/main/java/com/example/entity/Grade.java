package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Grades")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Grade extends Base{
    @Column(name = "grade_id", columnDefinition = "varchar(30)", unique = true)
    @NotNull
    private String gradeCode;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    @NotNull
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotNull
    private Student student;
    @Column
    private Float attend;
    @Column
    private Float midterm;
    @Column(name = "endofterm")
    private Float endOfTerm;
    @Column
    private Float test;
    @Column
    private Float practice;
    @Column
    private Float gpa;



}
