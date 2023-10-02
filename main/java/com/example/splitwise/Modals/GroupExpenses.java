package com.example.splitwise.Modals;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class GroupExpenses extends BaseModal {
    private int groupsId;
    private int expenseId;
}
