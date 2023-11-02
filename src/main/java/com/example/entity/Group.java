package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groups")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Group extends Base{
    @Column(unique = true)
    private String code;




    @OneToMany(mappedBy = "group")
    private Set<TimeTable> timeTables = new HashSet<>();


//    @OneToMany(mappedBy = "group")
//    private List<Register> registers = new ArrayList<>();

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