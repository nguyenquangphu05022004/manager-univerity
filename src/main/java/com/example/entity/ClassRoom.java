package com.example.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "classrooms")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class ClassRoom extends Base {
    @Column(name = "class_room_id", columnDefinition = "varchar(30)", unique = true)
    @NotNull
    private String classRoomCode;
    @Column(name = "roomname", columnDefinition = "nvarchar(30)")
    private String roomName;
    @Column(name = "house", columnDefinition = "nvarchar(20)")
    private String house;
    @Column(name = "studentquantity")
    private Integer studentQuantity;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToMany(mappedBy = "classRooms")
    private List<Student> students = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(unique = true, columnDefinition = "datetime2(0)", name = "date_time")
    private Timestamp dateTime;

}
