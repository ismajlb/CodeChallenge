package com.linkplus.LinkPlus.service;

import com.linkplus.LinkPlus.model.UserBank;
import com.linkplus.LinkPlus.repository.AccountRepository;
import com.linkplus.LinkPlus.repository.UserBankRepository;
import com.linkplus.LinkPlus.service.interfaces.IUserBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBankService implements IUserBankService {

    private final UserBankRepository bankUserRepository;

    @Override
    public String addUserBank(UserBank userBank) {
        try {
            UserBank bankUser = new UserBank();
            bankUser.setEmail(bankUser.getEmail());
            bankUser.setFirstname(userBank.getFirstname());
            bankUser.setLastname(userBank.getLastname());

            bankUserRepository.save(bankUser);

            return "User has been added";
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
