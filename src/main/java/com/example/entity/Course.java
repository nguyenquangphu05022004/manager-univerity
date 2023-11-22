package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "courses")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Course extends Base{
    @Column(name = "course")
    private String course;
    @Column(name = "code")
    private String code;
    @OneToMany(mappedBy = "course")
    private List<Student> students = new ArrayList<>();
    @ManyToMany(mappedBy = "courses")
    private List<SchoolYear> schoolYears = new ArrayList<>();

}
