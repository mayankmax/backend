package com.example.splitwise.Modals;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpensePaidBy extends BaseModal{

    private int paidByUser;
    private int amountPaid;
    private int paidByExpenses;
}
