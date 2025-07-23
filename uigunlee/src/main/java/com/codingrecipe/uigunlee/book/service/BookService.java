package com.codingrecipe.uigunlee.book.service;


import com.codingrecipe.uigunlee.book.service.request.RegisterBookRequest;
import com.codingrecipe.uigunlee.book.service.response.RegisterBookResponse;

public interface BookService {

    RegisterBookResponse register(RegisterBookRequest request, Long accountId);
}
