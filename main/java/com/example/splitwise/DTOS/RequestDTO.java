package com.example.splitwise.DTOS;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RequestDTO {
    private String userName;
    private String userEmail;
    private int userPhone;
    private String userPassword;
}
