package com.codingrecipe.uigunlee.book.controller.request_form;

import com.codingrecipe.uigunlee.book.service.request.RegisterBookRequest;
import com.codingrecipe.uigunlee.book.service.response.RegisterBookResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RegisterBookRequestForm {
    // 저장한 요청 정보
    final private String title;
    final private String content;
    final private String author;
    final private String isbn;

    // RequestForm을 Request로 변환
    public RegisterBookRequest toRegisterBookRequest() {
        return new RegisterBookRequest(title, content, author, isbn);
    }
}
