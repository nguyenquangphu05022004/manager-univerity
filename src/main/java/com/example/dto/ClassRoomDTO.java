package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class ClassRoomDTO extends GenericDTO {
    private String roomName;
    private String house;
    private Integer studentQuantity;
    private Integer studentQuantityCurrent;
    public ClassRoomDTO(Long id, String roomName,
                        String house, Integer studentQuantity) {
        super(id);
        this.roomName = roomName;
        this.house  = house;
        this.studentQuantity= studentQuantity;
        this.studentQuantity = 0;
    }
    private List<StudentDTO> students = new ArrayList<>();

}
