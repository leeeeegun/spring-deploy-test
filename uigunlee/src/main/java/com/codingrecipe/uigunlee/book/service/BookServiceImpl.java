package com.codingrecipe.uigunlee.book.service;

import com.codingrecipe.uigunlee.account.entity.Account;
import com.codingrecipe.uigunlee.account.repository.AccountRepository;
import com.codingrecipe.uigunlee.book.entity.Book;
import com.codingrecipe.uigunlee.book.repository.BookRepository;
import com.codingrecipe.uigunlee.book.service.request.RegisterBookRequest;
import com.codingrecipe.uigunlee.book.service.response.RegisterBookResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    final private BookRepository bookRepository;
    final private AccountRepository accountRepository;

    @Override
    public RegisterBookResponse register(RegisterBookRequest request, Long accountId) {
        Optional<Account> maybeAccount = accountRepository.findById(accountId);
        if (maybeAccount.isEmpty()) {
            log.info("요청한 account 존재하지 않습니다");
            return null;
        }

        Account account = maybeAccount.get();
        Book requestedBook = request.toBook(account);

        Book savedBook = bookRepository.save(requestedBook);
        return RegisterBookResponse.from(savedBook);
    }
}
