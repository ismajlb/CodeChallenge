package com.linkplus.LinkPlus.repository;

import com.linkplus.LinkPlus.model.UserBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBankRepository extends JpaRepository<UserBank, Long> {

    UserBank findByEmail(String email);

    UserBank findByAccountAccountNumber(String accountNumber);
}
