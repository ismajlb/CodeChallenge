package com.linkplus.LinkPlus.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankRequest {

    private String bankName;
    private double transactionFlatFeeAmount;
    private double transactionPercentFeeValue;
}
