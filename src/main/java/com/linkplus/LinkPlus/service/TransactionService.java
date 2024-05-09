package com.linkplus.LinkPlus.service;

import com.linkplus.LinkPlus.execptions.ResourceNotFoundException;
import com.linkplus.LinkPlus.model.Account;
import com.linkplus.LinkPlus.model.Transaction;
import com.linkplus.LinkPlus.model.enums.TypesOfFees;
import com.linkplus.LinkPlus.repository.AccountRepository;
import com.linkplus.LinkPlus.repository.TransactionRepository;
import com.linkplus.LinkPlus.service.interfaces.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    private double feePercentage = 5.00;

    @Override
    public void moneyTransfer(Long fromAccountId,
                              Long toAccountId,
                              double amount,
                              String reason,
                              TypesOfFees typesOfFees) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        if(amount <= 0)
            throw new RuntimeException("Transfer should be more then 0");

        Double calculatedFee = calculateFee(amount, String.valueOf(typesOfFees));
        toAccount.setBalance(toAccount.getBalance() - calculatedFee);
        fromAccount.setBalance(fromAccount.getBalance() - amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();

        transaction.setAmount(amount);
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setReason(reason);
        transaction.setTypesOfFees(TypesOfFees.valueOf(String.valueOf(typesOfFees)));

        transactionRepository.save(transaction);

    }

    private Double calculateFee(Double amount, String feeType) {
        if(feeType.trim().equals(TypesOfFees.FLAT_FEE.toString()))
            return amount - 10;

        return amount - (amount * feePercentage/100);

    }
}
