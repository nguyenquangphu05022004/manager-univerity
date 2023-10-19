package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@SuperBuilder(toBuilder = true)
@Getter
@NoArgsConstructor
public abstract class Person extends Base{
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

}
