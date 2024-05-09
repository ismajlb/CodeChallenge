package com.linkplus.LinkPlus.service.interfaces;

import com.linkplus.LinkPlus.model.Account;
import com.linkplus.LinkPlus.model.Bank;
import com.linkplus.LinkPlus.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBankService {
    Bank createBank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue);
    Account createAccount(int accountId, String userName);
    Transaction performTransaction(double amount, int originatingAccountId, int resultingAccountId, String transactionReason);
    List<Transaction> getTransactionsForAccount(int accountId);
    double getAccountBalance(int accountId);
    List<Account> getAllAccounts();
    double getTotalTransactionFeeAmount();
    double getTotalTransferAmount();
}
