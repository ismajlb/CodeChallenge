package com.linkplus.LinkPlus.service;

import com.linkplus.LinkPlus.execptions.ResourceNotFoundException;
import com.linkplus.LinkPlus.model.Account;
import com.linkplus.LinkPlus.model.UserBank;
import com.linkplus.LinkPlus.repository.AccountRepository;
import com.linkplus.LinkPlus.repository.UserBankRepository;
import com.linkplus.LinkPlus.service.interfaces.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;
    private final UserBankRepository bankUserRepository;


    @Override
    public void addAccount(Long id, double balance) throws ResourceNotFoundException {
        UserBank bankUser = bankUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank User not found!"));

        Account account1 = new Account();
        account1.setBalance(balance);
        account1.setUserBank(bankUser);

        accountRepository.save(account1);
    }

    @Override
    public void deposit(Long accountId, double amount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found!"));

        if(amount <= 0)
            throw new RuntimeException("Amount can not be below then 0 or 0!");

        account.setBalance(account.getBalance() + amount);

        accountRepository.save(account);
    }

    @Override
    public void withdraw(Account account) {

    }
}
