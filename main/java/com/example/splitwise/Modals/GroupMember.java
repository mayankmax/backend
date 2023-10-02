package com.example.splitwise.Modals;

import com.example.splitwise.Modals.enums.Role;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupMember extends BaseModal {


    private int user;
    private int groupsId;
    private Role role;

}
