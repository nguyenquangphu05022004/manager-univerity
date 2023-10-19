package com.example.dto;

import com.example.entity.SemesterEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class SemesterDTO extends GenericDTO{
    private SemesterEnum semesterEnum;
    private List<SchoolYearDTO> schoolYearDTOs = new ArrayList<>();
    private String semester;

    @Override
    public String toString() {
        return "SemesterDTO{" +
                "semesterEnum=" + semesterEnum +
                ", schoolYearDTOs=" + schoolYearDTOs +
                ", semester='" + semester + '\'' +
                '}';
    }
}
