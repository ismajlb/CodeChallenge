package com.linkplus.LinkPlus.controller;

import com.linkplus.LinkPlus.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void addAccount(@RequestParam(value="id") Long id, @RequestParam(value="balance") double balance) {
        accountService.addAccount(id, balance);
    }

    @PostMapping("deposit")
    public void deposit(@RequestParam(value="accountId") Long accountId, @RequestParam(value="amount") Double amount) {
        accountService.deposit(accountId, amount);
    }

    @PostMapping("withdraw")
    public void withdraw(@RequestBody Long accountId, Double amount) {
        accountService.withdraw(accountId, amount);
    }
}
