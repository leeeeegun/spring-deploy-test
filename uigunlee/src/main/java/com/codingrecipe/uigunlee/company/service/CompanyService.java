package com.codingrecipe.uigunlee.company.service;

import com.codingrecipe.uigunlee.company.service.request.RegisterCompanyRequest;
import com.codingrecipe.uigunlee.company.service.response.RegisterCompanyResponse;

public interface CompanyService {
    RegisterCompanyResponse register(RegisterCompanyRequest request, Long accountId);

}
