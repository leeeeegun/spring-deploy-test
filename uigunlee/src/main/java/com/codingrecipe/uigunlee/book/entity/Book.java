package com.codingrecipe.uigunlee.book.entity;

import com.codingrecipe.uigunlee.account.entity.Account;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String author;
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Book(String title, String content, String author, String isbn, Account account) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.isbn = isbn;
    }
}
