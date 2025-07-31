package com.codingrecipe.uigunlee.company.controller.response_form;

import com.codingrecipe.uigunlee.company.entity.Company;
import com.codingrecipe.uigunlee.company.service.response.RegisterCompanyResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterCompanyResponseForm {

    private final Long CompanyId;
    private final String companyName;
    private final String business;
    private final String ceoName;
    private final int companyNum;
    private final String registerAccountNickname;

    public static RegisterCompanyResponseForm from(RegisterCompanyResponse response) {
        return new RegisterCompanyResponseForm(
          response.getCompanyId(),
          response.getCompanyName(),
          response.getBusiness(),
          response.getCeoName(),
          response.getCompanyNum(),
          response.getRegisterAccountNickname()
        );
    }
}
