package com.example.splitwise.DTOS;

import com.example.splitwise.Modals.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GroupResponseDTO {
    private String message;
    private String status;
    private Users createdBY;
}
