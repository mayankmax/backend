package com.example.splitwise.DTOS;

import com.example.splitwise.Modals.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GroupRequestDTO {

    private String groupName;
    private Users admin;
    private Date createdAt;
}
