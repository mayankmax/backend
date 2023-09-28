package com.example.splitwise.Modals;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpensesSharedBy extends BaseModal{

    private int sharedByUser;
    private int amountShared;
    private int expensesharedId;
}