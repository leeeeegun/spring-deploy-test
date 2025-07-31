package com.codingrecipe.uigunlee.company.service;

import com.codingrecipe.uigunlee.account.entity.Account;
import com.codingrecipe.uigunlee.account.repository.AccountRepository;
import com.codingrecipe.uigunlee.company.entity.Company;
import com.codingrecipe.uigunlee.company.repository.CompanyRepository;
import com.codingrecipe.uigunlee.company.service.request.RegisterCompanyRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final AccountRepository accountRepository;

    @Override
    public RegisterCompanyResponse register(RegisterCompanyRequest request, Long accountId) {
        Optional<Account> maybeAccount = accountRepository.findById(accountId);

        if (maybeAccount.isPresent()) {
            log.info("잘못된 접근입니다.");
            return null;
        }

        Account account = maybeAccount.get();
        Company requestedCompany = request.toCompany(account);

        Company savedCompany = companyRepository.save(requestedCompany);
        return RegisterCompanyResponse.from(savedCompany);
    }
}
