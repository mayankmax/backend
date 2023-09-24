package com.example.splitwise.Modals;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Groups extends BaseModal{

    @Size(min = 3 ,max = 20)
    @NotEmpty
    private String groupName;
    private Users user;
}
