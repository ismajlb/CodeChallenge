package com.linkplus.LinkPlus.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {
    private Long fromAccount;
    private Long toAccount;
    private double amount;
    private String reason;
    private String feeType;
}
