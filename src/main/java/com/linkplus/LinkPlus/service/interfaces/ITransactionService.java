package com.linkplus.LinkPlus.service.interfaces;

public interface ITransactionService {
    void moneyTransfer(Long fromAccount,
                       Long toAccount,
                       double amount,
                       String reason);
}
