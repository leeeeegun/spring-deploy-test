package com.codingrecipe.uigunlee.company.service.request;

import com.codingrecipe.uigunlee.account.entity.Account;
import com.codingrecipe.uigunlee.company.entity.Company;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
public class RegisterCompanyRequest {
    private String companyName;
    private String business;
    private String ceoName;
    private int companyNum;

    public RegisterCompanyRequest(String companyName, String business, String ceoName, int companyNum) {
        this.companyName = companyName;
        this.business = business;
        this.ceoName = ceoName;
        this.companyNum = companyNum;
    }

    public Company toCompany(Account account) {
        return new Company(companyName, business, ceoName, companyNum, account);
    }
}
