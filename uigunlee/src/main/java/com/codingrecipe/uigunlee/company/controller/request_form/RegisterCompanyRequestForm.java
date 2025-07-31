package com.codingrecipe.uigunlee.company.controller.request_form;

import com.codingrecipe.uigunlee.company.service.request.RegisterCompanyRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RegisterCompanyRequestForm {

    private final String companyName;
    private final String business;
    private final String ceoName;
    private final int companyNum;

    // RequestForm을 Request로 변환
    public RegisterCompanyRequest toRegisterCompanyRequest(){
        return new RegisterCompanyRequest(companyName, business, ceoName, companyNum);
    }
}
