package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public class Person extends Base{
    @Column(name = "fullname" , columnDefinition = "NVARCHAR(80)")
    private String fullName;
    @Column(name = "birthofdate")
    private Date birthOfDate;
    @Column(columnDefinition = "NVARCHAR(100)")
    private String address;
    @Column(columnDefinition = "VARCHAR(80)")
    private String email;
    @Column(columnDefinition = "VARCHAR(15)")
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name = "major_id")
    @NotNull
    private Major major;
    @Column(columnDefinition = "varchar(50)", unique = true)
    private String username;
    @Column(columnDefinition = "varchar(100)")
    private String password;

    @ManyToMany
    @JoinTable(name = "person_role",
        joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    @OneToOne(mappedBy = "person")
    private Student student;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Teacher teacher;

}
