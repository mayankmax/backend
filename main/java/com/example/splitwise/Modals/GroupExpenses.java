package com.example.splitwise.Modals;

//As Expense and Group are M:M mapping so we have created a mapping class

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GroupExpenses extends  BaseModal{
    private Groups group;
    private Expenses expenses;
}
