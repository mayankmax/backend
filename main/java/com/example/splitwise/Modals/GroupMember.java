package com.example.splitwise.Modals;

import com.example.splitwise.Modals.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupMember {


    private Users user;
    private Groups group;
    private Role role;
}
