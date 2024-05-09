package com.linkplus.LinkPlus.service;

import com.linkplus.LinkPlus.model.Account;
import com.linkplus.LinkPlus.model.Bank;
import com.linkplus.LinkPlus.model.Transaction;
import com.linkplus.LinkPlus.repository.BankRepository;
import com.linkplus.LinkPlus.service.interfaces.IBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class BankServiceImpl implements IBankService {

    private BankRepository bankRepository;
    private Map<Integer, List<Transaction>> transactionHistory;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
        this.transactionHistory = new HashMap<>();
    }

    @Override
    public Bank createBank(String bankName, double transactionFlatFeeAmount, double transactionPercentFeeValue) {
        return bankRepository.createBank(bankName, transactionFlatFeeAmount, transactionPercentFeeValue);
    }

    @Override
    public Account createAccount(int accountId, String userName) {
        return bankRepository.createAccount(accountId, userName);
    }

    @Override
    public Transaction performTransaction(double amount, int originatingAccountId, int resultingAccountId, String transactionReason) {
        Account originatingAccount = bankRepository.getAccountById(originatingAccountId);
        Account resultingAccount = bankRepository.getAccountById(resultingAccountId);

        if (originatingAccount == null || resultingAccount == null) {
            throw new IllegalArgumentException("One or both accounts do not exist.");
        }

        double fee = calculateTransactionFee(amount, originatingAccount, resultingAccount);

        if (originatingAccount.getBalance() < (amount + fee)) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        originatingAccount.setBalance(originatingAccount.getBalance() - (amount + fee));
        resultingAccount.setBalance(resultingAccount.getBalance() + amount);

        Transaction transaction = bankRepository.performTransaction(amount, originatingAccountId, resultingAccountId, transactionReason);
        saveTransactionHistory(originatingAccountId, transaction);

        return transaction;
    }

    @Override
    public List<Transaction> getTransactionsForAccount(int accountId) {
        return transactionHistory.getOrDefault(accountId, new ArrayList<>());
    }

    @Override
    public double getAccountBalance(int accountId) {
        Account account = bankRepository.getAccountById(accountId);
        if (account == null) {
            throw new IllegalArgumentException("Account does not exist.");
        }
        return account.getBalance();
    }

    @Override
    public List<Account> getAllAccounts() {
        return bankRepository.getAllAccounts();
    }

    @Override
    public double getTotalTransactionFeeAmount() {
        return bankRepository.getBank().getTotalTransactionFeeAmount();
    }

    @Override
    public double getTotalTransferAmount() {
        return bankRepository.getTotalTransferAmount();
    }

    private double calculateTransactionFee(double amount, Account originatingAccount, Account resultingAccount) {
        double fee;
        if (originatingAccount.getId() == resultingAccount.getId()) {
            fee = 0; // No fee for internal transfers
        } else {
            // Calculate fee based on flat fee or percent fee
            fee = bankRepository.getBank().getTransactionFlatFeeAmount() +
                    (bankRepository.getBank().getTransactionPercentFeeValue() / 100) * amount;
        }
        return fee;
    }

    private void saveTransactionHistory(int accountId, Transaction transaction) {
        if (!transactionHistory.containsKey(accountId)) {
            transactionHistory.put(accountId, new ArrayList<>());
        }
        transactionHistory.get(accountId).add(transaction);
    }
}
