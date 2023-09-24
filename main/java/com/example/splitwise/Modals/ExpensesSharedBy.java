package com.example.splitwise.Modals;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ExpensesSharedBy extends BaseModal{

    private Users sharedByUser;
    private int amountShared;
    private Expenses sharedByExpenses;
}