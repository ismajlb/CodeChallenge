package com.linkplus.LinkPlus.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    private double amount;
    private int originatingAccountId;
    private int resultingAccountId;
    private String transactionReason;
}
