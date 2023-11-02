package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Teachers")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Teacher extends Base {


    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @OneToMany(mappedBy = "teacher")
    private Set<TimeTable> timeTables = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "teacher_subject",
    joinColumns = @JoinColumn(name = "teacher_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects = new ArrayList<>();
}
