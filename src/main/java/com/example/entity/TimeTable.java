package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "time_table")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class TimeTable extends Base{

    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "start_time")
    private Time startTime;
    @Column(name = "end_time")
    private Time endTime;


    @Column(name = "dayofweek")
    private Integer dayOfWeek;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private ClassRoom classRoom;



    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}
