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
public class splitwise_group extends BaseModal{

    @Size(min = 3 ,max = 20)
    @NotEmpty
    private String groupsName;
    private int adminId;
   // private Date createdAt;

    public splitwise_group(String groupsName, int adminId, Date createdAt) {
        this.groupsName = groupsName;
        this.adminId = adminId;
        //this.createdAt = createdAt;
    }
}
