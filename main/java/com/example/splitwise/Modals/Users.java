package com.example.splitwise.Modals;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;


@Getter
@Setter
public class Users extends BaseModal {
    @Size(min = 3 ,max = 20)
    @NotEmpty
    private String userName;
    @Size(min = 3 ,max = 20)
    @NotEmpty
    @Email
    private String userEmail;

    @Size(min = 10 ,max = 10)
    @NotEmpty
    private int userPhone;
    @Size(min = 8 ,max = 20)
    @NotEmpty
    private String userPassword;

}
