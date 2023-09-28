package com.example.splitwise.Modals;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModal {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
}
