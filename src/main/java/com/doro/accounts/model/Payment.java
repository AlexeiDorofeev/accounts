package com.doro.accounts.model;

import lombok.Data;

@Data
public class Payment {
    private Long id;
    private User employee;
    private String period;
    private Long salary;
}
