package com.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class PersonDTO extends GenericDTO{
    private String fullName;
    private Date birthOfDate;
    private String address;
    private String email;
    private String phoneNumber;
    private Long majorId;
    private String majorCode;
    private String username;
    private String password;

}
