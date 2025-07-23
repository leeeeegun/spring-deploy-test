package com.codingrecipe.uigunlee.account.controller.response_form;

import com.codingrecipe.uigunlee.account.service.reponse.RegisterAccountResponse;
import com.codingrecipe.uigunlee.book.controller.response_form.RegisterBookResponseForm;
import com.codingrecipe.uigunlee.book.service.response.RegisterBookResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterAccountResponseForm {
    final private String userToken;
    final private String email;
    final private String nickname;

    public static RegisterAccountResponseForm from(
            final RegisterAccountResponse response,
            final String userToken) {

        return new RegisterAccountResponseForm(
                userToken,
                response.getEmail(),
                response.getNickname()
        );
    }
}