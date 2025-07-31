package com.codingrecipe.uigunlee.book.controller.response_form;

import com.codingrecipe.uigunlee.book.service.response.RegisterBookResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterBookResponseForm {
    private final Long bookId;
    private final String title;
    private final String content;
    private final String isbn;
    private final String registerAccountNickname;

    public static RegisterBookResponseForm from(RegisterBookResponse response) {
        return new RegisterBookResponseForm(
                response.getBookId(),
                response.getTitle(),
                response.getContent(),
                response.getIsbn(),
                response.getRegisterAccountNickname()
        );
    }
}
