package com.linkplus.LinkPlus.controller;

import com.linkplus.LinkPlus.request.TransferRequest;
import com.linkplus.LinkPlus.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "api/v1/transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public void moneyTransfer(@RequestBody TransferRequest transferRequest) {
        transactionService.moneyTransfer(transferRequest);
    }

}