package com.codingrecipe.uigunlee.account.controller.request_form;

import com.codingrecipe.uigunlee.account.service.request.RegisterAccountRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterAccountRequestForm {
    final private String email;
    final private String nickname;

    public RegisterAccountRequest toRegisterAccountRequest() {
        return new RegisterAccountRequest(email, nickname);
    }
}
