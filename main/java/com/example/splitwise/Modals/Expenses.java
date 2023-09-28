package com.example.splitwise.Modals;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Entity // This annotation marks the class as a JPA entity
@Getter
@Setter
public class Expenses extends BaseModal {

    private int amount;
    private String expenseName;



    private int userId;
}
