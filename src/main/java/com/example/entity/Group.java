package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Group extends Base{
    @Column(unique = true)
    private String code;

    @ManyToMany(mappedBy = "groups")
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "groupRequest")
    private List<StudentRequest> groupRequests = new ArrayList<>();
    @OneToMany(mappedBy = "groupResponse")
    private List<StudentResponse> groupResponses = new ArrayList<>();


    @OneToMany(mappedBy = "group")
    private List<Register> registers = new ArrayList<>();

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Group) {
            Group group = (Group) obj;
            if(group.getId().compareTo(getId()) == 0) {
                return true;
            }
        }
        return false;
    }
}