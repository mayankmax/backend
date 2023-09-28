package com.example.splitwise.Modals;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Groups extends BaseModal{

    @Size(min = 3 ,max = 20)
    @NotEmpty
    private String groupName;
    private int admin;
   // private Date createdAt;

    public Groups(String groupName, int admin, Date createdAt) {
        this.groupName = groupName;
        this.admin = admin;
        //this.createdAt = createdAt;
    }
}
