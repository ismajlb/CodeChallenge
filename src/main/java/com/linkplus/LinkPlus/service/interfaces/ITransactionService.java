package com.linkplus.LinkPlus.service.interfaces;

import com.linkplus.LinkPlus.model.enums.TypesOfFees;

public interface ITransactionService {
    void moneyTransfer(Long fromAccount,
                       Long toAccount,
                       double amount,
                       String reason,
                       TypesOfFees typesOfFees);

}
