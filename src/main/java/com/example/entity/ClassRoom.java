package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classrooms")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class ClassRoom extends Base {

    @Column(name = "roomname", columnDefinition = "nvarchar(30)")
    private String roomName;
    @Column(name = "house", columnDefinition = "nvarchar(20)")
    private String house;
    @Column(name = "studentquantity")
    private Integer studentQuantity;

    @Column(name = "studentQuantityCurrent")
    private Integer studentQuantityCurrent;
    @ManyToMany
    @JoinTable(name = "room_student", joinColumns = @JoinColumn(name = "classRoomId"),
             inverseJoinColumns  = @JoinColumn(name = "studentId"))
    private List<Student> students;

    @OneToMany(mappedBy = "classRoom")
    private List<TimeTable> timeTables = new ArrayList<>();

}
