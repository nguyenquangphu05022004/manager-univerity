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


    @OneToMany(mappedBy = "semester")
    private List<RegisterOfMajor> registerOfMajors = new ArrayList<>();
}
