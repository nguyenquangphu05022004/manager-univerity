package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "register_of_major")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Getter
public class RegisterOfMajor extends Base{
    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;
    @ManyToMany
    @JoinTable(name = "register_of_major_subject",
        joinColumns =  @JoinColumn(name = "register_of_major"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "subject_major_schoolyear",
        joinColumns = @JoinColumn(name = "register_major_id"),
            inverseJoinColumns = @JoinColumn(name = "schoolyear_id")
    )
    private List<SchoolYear> schoolYears = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Semester semester;
}
