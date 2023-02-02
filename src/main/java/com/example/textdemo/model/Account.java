package com.example.textdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@With
@AllArgsConstructor
@Data
public class Account {
    private long id;
    private String name;
    private String surname;
    private double balance;
}
