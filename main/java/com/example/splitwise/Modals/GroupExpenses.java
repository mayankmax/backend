package com.example.splitwise.Modals;

//As Expense and Group are M:M mapping so we have created a mapping class

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupExpenses extends  BaseModal{
    private int group;
    private int expenseId;
}
