package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Students")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Student extends Person {

    @OneToMany(mappedBy = "student")
    private List<Register> registers = new ArrayList<>();


    @OneToMany(mappedBy = "student")
    private List<Grade> studentOfGrades = new ArrayList<>();

    @OneToMany(mappedBy = "studentRequest")
    private List<StudentRequest> studentRequests = new ArrayList<>();
    @OneToMany(mappedBy = "studentResponse")
    private List<StudentResponse> studentResponses = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "student_classroom",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id"))
    private List<ClassRoom> classRooms = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>();


    @ManyToMany(mappedBy =  "students")
    private List<SchoolYear> schoolYears = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;



    @Override
    public boolean equals(Object o) {
      if(o instanceof Student) {
          Student student = (Student)o;
          if(student.getId() == getId()) {
              return true;
          }
      }
      return false;
    }




}
