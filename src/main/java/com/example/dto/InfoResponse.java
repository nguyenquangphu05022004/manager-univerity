package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class InfoResponse {
    private String token;
    private String username;
    private String fullName;
    private Date expiration;


    public InfoResponse(String token, String username,
                        String fullName, Date expiration) {
        this.token = token;
        this.username = username;
        this.fullName = fullName;
        this.expiration = expiration;
    }
}
