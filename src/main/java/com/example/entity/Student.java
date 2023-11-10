package com.example.entity;

import com.example.entity.blog.Blog;
import com.example.entity.blog.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Students")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Student extends Base {

    @OneToMany(mappedBy = "student")
    private List<Register> registers = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Comment> comments;

    @OneToMany(mappedBy = "student")
    private List<Blog> blogs;

    @ManyToMany
    @JoinTable(name = "student_classroom",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "classroom_id"))
    private List<ClassRoom> classRooms = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "person_id", unique = true)
    private Person person;


    @ManyToMany(mappedBy = "students")
    private List<SchoolYear> schoolYears = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "student")
    private List<StudentExchangeRegister> studentExchangeRegisters;

    @OneToMany(mappedBy = "student")
    private List<StudentRequestExchange> studentRequestExchanges;
    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student student = (Student) o;
            if (student.getId() == getId()) {
                return true;
            }
        }
        return false;
    }


}
