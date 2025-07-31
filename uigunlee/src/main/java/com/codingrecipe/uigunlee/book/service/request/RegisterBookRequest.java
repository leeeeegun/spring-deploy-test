package com.codingrecipe.uigunlee.book.service.request;

import com.codingrecipe.uigunlee.account.entity.Account;
import com.codingrecipe.uigunlee.book.entity.Book;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterBookRequest {
    private String title;
    private String content;
    private String author;
    private String isbn;

    public RegisterBookRequest(String title, String content, String author, String isbn) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.isbn = isbn;
    }

    public Book toBook(Account account) {
        return new Book(title, content, author, isbn, account);
    }
}
