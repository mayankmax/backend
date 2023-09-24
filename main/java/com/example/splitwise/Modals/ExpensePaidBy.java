package com.example.splitwise.Modals;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ExpensePaidBy extends BaseModal{

    private Users paidByUser;
    private int amountPaid;
    private Expenses paidByExpenses;
}
