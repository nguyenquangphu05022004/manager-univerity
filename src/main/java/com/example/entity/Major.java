package com.example.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "majors")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Major extends Base{

    @Column(name = "major_code", columnDefinition = "nvarchar(30)", unique = true)
    @NotNull
    private String majorCode;
    @Column(columnDefinition = "nvarchar(60)")
    private String name;

    @ManyToMany(mappedBy = "majors")
    private List<Subject> subjects = new ArrayList<>();

    @OneToMany(mappedBy = "major")
    private List<RegisterOfMajor> registerOfMajors;



    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Major) {
            Major major = (Major)obj;
            if(major.getMajorCode().compareTo(majorCode) == 0) {
                return true;
            }
        }
        return false;
    }
}
