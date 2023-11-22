package com.example.entity;

import com.example.entity.embedded.InfoGrade;
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
    @Embedded
    private InfoGrade infoGrade;

    @Column(name = "gpa")
    private Float gpa;

    @ManyToOne
    @JoinColumn(name = "coefficient_id")
    private Coefficient coefficient;
}
