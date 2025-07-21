package com.codingrecipe.uigunlee.account.service;


import com.codingrecipe.uigunlee.account.service.reponse.RegisterAccountResponse;
import com.codingrecipe.uigunlee.account.service.request.RegisterAccountRequest;

public interface AccountService {
    RegisterAccountResponse register(RegisterAccountRequest request);
}
