package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class StudentRequestExchangeDTO extends GenericDTO{
    private Boolean statusRequest;
    private Boolean statusExchange;
    private StudentExchangeRegisterDTO studentExchangeRegisterDTO;
}
