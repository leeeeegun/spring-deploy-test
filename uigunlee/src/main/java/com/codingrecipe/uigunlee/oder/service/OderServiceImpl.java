package com.codingrecipe.uigunlee.oder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {

    final private OrdersRepository ordersRepository;
    final private BookRepository bookRepository;
    final private AccountRepository accountRepository;

    @Override
    public CreateOrdersResponse create(CreateOrdersRequest request) {
        Long bookId = request.getBookId();
        Optional<Book> maybeBook = bookRepository.findById(bookId);
        if (maybeBook.isEmpty()) {
            return null;
        }
        Book requestedBook = maybeBook.get();

        Long accountId = request.getAccountId();
        Optional<Account> maybeAccount = accountRepository.findById(accountId);
        if (maybeBook.isEmpty()) {
            return null;
        }
        Account requestedAccount = maybeAccount.get();

        Orders requestedOrders = request.toOrders(requestedBook, requestedAccount);
        Orders savedOrders = ordersRepository.save(requestedOrders);

        return CreateOrdersResponse.from(savedOrders);
    }
}