package com.linkplus.LinkPlus.controller;

import com.linkplus.LinkPlus.model.Account;
import com.linkplus.LinkPlus.model.Bank;
import com.linkplus.LinkPlus.model.Transaction;
import com.linkplus.LinkPlus.request.AccountRequest;
import com.linkplus.LinkPlus.request.BankRequest;
import com.linkplus.LinkPlus.request.TransactionRequest;
import com.linkplus.LinkPlus.service.BankServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
@AllArgsConstructor
public class BankController {

    private final BankServiceImpl bankServiceImpl;

    @PostMapping("/createBank")
    public Bank createBank(@RequestBody BankRequest bankRequest) {
        return bankServiceImpl.createBank(bankRequest.getBankName(), bankRequest.getTransactionFlatFeeAmount(), bankRequest.getTransactionPercentFeeValue());
    }

    @PostMapping("/createAccount")
    public Account createAccount(@RequestBody AccountRequest accountRequest) {
        return bankServiceImpl.createAccount(accountRequest.getAccountId(), accountRequest.getUserName());
    }

    @PostMapping("/performTransaction")
    public Transaction performTransaction(@RequestBody TransactionRequest transactionRequest) {
        return bankServiceImpl.performTransaction(
                transactionRequest.getAmount(),
                transactionRequest.getOriginatingAccountId(),
                transactionRequest.getResultingAccountId(),
                transactionRequest.getTransactionReason()
        );
    }

    @GetMapping("/transactions/{accountId}")
    public List<Transaction> getTransactionsForAccount(@PathVariable int accountId) {
        return bankServiceImpl.getTransactionsForAccount(accountId);
    }

    @GetMapping("/accountBalance/{accountId}")
    public double getAccountBalance(@PathVariable int accountId) {
        return bankServiceImpl.getAccountBalance(accountId);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return bankServiceImpl.getAllAccounts();
    }

    @GetMapping("/totalTransactionFeeAmount")
    public double getTotalTransactionFeeAmount() {
        return bankServiceImpl.getTotalTransactionFeeAmount();
    }

    @GetMapping("/totalTransferAmount")
    public double getTotalTransferAmount() {
        return bankServiceImpl.getTotalTransferAmount();
    }
}