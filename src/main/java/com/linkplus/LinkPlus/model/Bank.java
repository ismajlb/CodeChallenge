package com.linkplus.LinkPlus.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Bank")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String bankName;

    @OneToMany(mappedBy = "bank")
    private List<Account> accounts;

    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;
}
