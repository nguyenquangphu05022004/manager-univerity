package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "student_response")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class StudentResponse extends Base{
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentResponse;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subjectResponse;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group groupResponse;

    @ManyToMany
    @JoinTable(name = "student_response_request",
            joinColumns = @JoinColumn(name = "student_response"),
            inverseJoinColumns = @JoinColumn(name = "student_request"))
    private List<StudentRequest> studentRequests = new ArrayList<>();
    @Column(name = "status")
    private Boolean status;
    @Column(name = "exchange")
    private Boolean exchange;
    @Override
    public boolean equals(Object o) {
        if(o instanceof StudentResponse) {
            StudentResponse studentResponse = (StudentResponse)o;
            if(getId() == studentResponse.getId()) {
                return true;
            }
        }
        return false;
    }


}