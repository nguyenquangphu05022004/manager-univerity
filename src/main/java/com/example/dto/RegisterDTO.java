package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class RegisterDTO extends GenericDTO{
    private Long studentId;
    private TimeTableDTO timeTableDTO;
    private Boolean isExchange;
    private InfoRegisterOfMajor infoRegisterOfMajor;
    @Getter
    @AllArgsConstructor
    @Builder
    public static class InfoRegisterOfMajor {
        private Long registerOfMajorId;
        private TuitionDTO tuitionDTO;

    }
}
