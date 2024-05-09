package com.linkplus.LinkPlus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

    private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;
}
