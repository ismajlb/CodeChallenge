package com.linkplus.LinkPlus.repository;

import com.linkplus.LinkPlus.model.Account;
import com.linkplus.LinkPlus.model.Bank;
import com.linkplus.LinkPlus.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank createBank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue);
    Account createAccount(int accountId, String userName);
    Transaction performTransaction(double amount, int originatingAccountId, int resultingAccountId, String transactionReason);
    Account getAccountById(int accountId);
    List<Account> getAllAccounts();

    double getTotalTransferAmount();
    Bank getBank();
}