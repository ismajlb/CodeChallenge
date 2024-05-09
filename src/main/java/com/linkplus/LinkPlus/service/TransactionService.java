package com.linkplus.LinkPlus.service;

import com.linkplus.LinkPlus.service.interfaces.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {
    @Override
    public void moneyTransfer(Long fromAccount, Long toAccount, double amount, String reason) {

    }
}
