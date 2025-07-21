package com.codingrecipe.uigunlee.account.service;

import com.codingrecipe.uigunlee.account.entity.Account;
import com.codingrecipe.uigunlee.account.repository.AccountRepository;
import com.codingrecipe.uigunlee.account.service.reponse.RegisterAccountResponse;
import com.codingrecipe.uigunlee.account.service.request.RegisterAccountRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    final private AccountRepository accountRepository;

    @Override
    public RegisterAccountResponse register(RegisterAccountRequest request) {
        Account requestedAccount = request.toAccount();
        Account savedAccount = accountRepository.save(requestedAccount);

        return RegisterAccountResponse.from(savedAccount);
    }
}