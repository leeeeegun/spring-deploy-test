package com.codingrecipe.uigunlee.kakao_authentication.service;

import com.codingrecipe.uigunlee.kakao_authentication.service.response.KakaoUserInfoResponse;

public interface KakaoAuthenticationService {
    KakaoUserInfoResponse handleLogin(String code);
}