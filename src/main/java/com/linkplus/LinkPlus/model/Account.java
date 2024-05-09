package com.linkplus.LinkPlus.model;

import jakarta.persistence.*;
import org.apache.catalina.User;

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String accountNumber;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "userBank_id")
    private UserBank userBank;
}
