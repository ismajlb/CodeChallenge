package com.linkplus.LinkPlus.service.interfaces;

import com.linkplus.LinkPlus.execptions.ResourceNotFoundException;
import com.linkplus.LinkPlus.model.Account;

public interface IAccountService {

    void addAccount(Long id, double balance);
    void deposit(Long accountId, double amount);
    void withdraw(Long accountId, double amount);

}
