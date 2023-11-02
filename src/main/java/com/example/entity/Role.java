package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@SuperBuilder
@NoArgsConstructor
public class Role extends Base {
    @Column(columnDefinition = "nvarchar(30)")
    private String name;
    @Column(columnDefinition = "varchar(20)")
    private String code;
    @ManyToMany(mappedBy = "roles")
    private List<Person> persons = new ArrayList<>();

    @Override
    public String toString() {
        return code;
    }
}
