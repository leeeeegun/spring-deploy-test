package com.codingrecipe.uigunlee.company.service.response;

import com.codingrecipe.uigunlee.company.entity.Company;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterCompanyResponse {
    private final Long CompanyId;
    private final String companyName;
    private final String business;
    private final String ceoName;
    private final int companyNum;
    private final String registerAccountNickname;

    public static RegisterCompanyResponse from(final Company company) {
        return new RegisterCompanyResponse(
                company.getId(),
                company.getCompanyName(),
                company.getBusiness(),
                company.getCeoName(),
                company.getCompanyNum(),
                company.getAccount().getNickname()
        );
    }
}
