package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schoolyear")
@SuperBuilder(toBuilder =  true)
@NoArgsConstructor
@Getter
public class SchoolYear extends Base{


    @Column(name = "schoolyear")
    private String schoolYear;

    @ManyToMany
    @JoinTable(name = "schoolyear_student",
        joinColumns = @JoinColumn(name = "schoolyear_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "schoolyear_course",
        joinColumns = @JoinColumn(name = "schoolyear_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy =  "schoolYear")
    private List<RegisterOfMajor> registerOfMajors = new ArrayList<>();

}
