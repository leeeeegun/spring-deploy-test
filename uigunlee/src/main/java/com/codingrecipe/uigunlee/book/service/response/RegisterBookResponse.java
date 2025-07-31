package com.codingrecipe.uigunlee.book.service.response;

import com.codingrecipe.uigunlee.book.entity.Book;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterBookResponse {
    private final Long bookId;
    private final String title;
    private final String content;
    private final String isbn;
    private final String registerAccountNickname;

    public RegisterBookResponse from(final Book book) {
        return new RegisterBookResponse(
                book.getId(),
                book.getTitle(),
                book.getContent(),
                book.getIsbn(),
                book.getAccount().getNickname()
        );
    }
}
