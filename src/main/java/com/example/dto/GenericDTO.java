package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public abstract class GenericDTO {
    private Long id;
    private Date createDate;
    private String createBy;
    private String modifiedBy;
    private Date modifiedDate;


}
