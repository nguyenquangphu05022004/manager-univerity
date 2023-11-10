package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class StudentExchangeRegisterDTO extends GenericDTO{
    private RegisterDTO registerDTO;
    private Boolean statusRequest;
    private StudentDTO studentDTO;
    private Boolean statusExchange;

}
