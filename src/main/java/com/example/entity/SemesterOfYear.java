package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "semesterOfYear")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class SemesterOfYear extends Base{

    @ManyToOne
    @JoinColumn(name = "schoolYearId")
    private SchoolYear schoolYear;

    @ManyToOne
    @JoinColumn(name = "semesterId")
    private Semester semester;

}
