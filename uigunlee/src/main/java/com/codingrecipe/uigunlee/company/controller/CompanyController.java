package com.codingrecipe.uigunlee.company.controller;


import com.codingrecipe.uigunlee.company.controller.request_form.RegisterCompanyRequestForm;
import com.codingrecipe.uigunlee.company.controller.response_form.RegisterCompanyResponseForm;
import com.codingrecipe.uigunlee.company.service.CompanyService;
import com.codingrecipe.uigunlee.company.service.request.RegisterCompanyRequest;
import com.codingrecipe.uigunlee.company.service.response.RegisterCompanyResponse;
import com.codingrecipe.uigunlee.redis_cache.RedisCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    private final RedisCacheService redisCacheService;

    @PostMapping("/company/register")
    public RegisterCompanyResponseForm registerCompany(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody RegisterCompanyRequestForm requestForm) {

        String userToken = authorizationHeader.startsWith("Bearer ") ?
                authorizationHeader.substring("Bearer ".length()) : authorizationHeader;

        Long accountId = redisCacheService.getValueByKey(userToken, Long.class);

        if (accountId == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "유효하지 않는 토큰입니다.");
        }

        RegisterCompanyRequest request = requestForm.toRegisterCompanyRequest();
        RegisterCompanyResponse response = companyService.register(request, accountId);

        return RegisterCompanyResponseForm.from(response);
    }
}
