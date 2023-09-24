package com.example.splitwise.Modals;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter

public class Expenses extends BaseModal{

    private int amount;
    private String expenseName;
    private Date createdAt;
    private Users userExpense;

}
