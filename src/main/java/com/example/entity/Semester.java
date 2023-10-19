package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semester")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
public class Semester extends  Base{

    @Enumerated(EnumType.STRING)
    private SemesterEnum semester;

    @ManyToMany(mappedBy = "semesters")
    private List<SchoolYear> schoolYears = new ArrayList<>();

    @OneToMany(mappedBy = "semester")
    private List<RegisterOfMajor> registerOfMajors = new ArrayList<>();
}
