package com.codingrecipe.uigunlee.kakao_authentication.controller.respones_form;

import com.codingrecipe.uigunlee.kakao_authentication.service.response.KakaoUserInfoResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class KakaoLoginResponseForm {
    final private String email;
    final private String nickname;
    final private String userToken;

    public static KakaoLoginResponseForm from(
            KakaoUserInfoResponse kakaoUserInfoResponse,
            String temporaryUserToken) {

        return new KakaoLoginResponseForm(
                kakaoUserInfoResponse.getEmail(),
                kakaoUserInfoResponse.getNickname(),
                temporaryUserToken
        );
    }
}