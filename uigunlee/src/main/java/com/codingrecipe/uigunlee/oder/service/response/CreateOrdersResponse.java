package com.codingrecipe.uigunlee.oder.service.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateOrdersResponse {
    final private Long bookId;
    final private String bookTitle;
    final private Long quantity;
    final private Long price;

    public static CreateOrdersResponse from(final Orders orders) {
        Book orderedBook = orders.getBook();

        return new CreateOrdersResponse(
                orderedBook.getId(),
                orderedBook.getTitle(),
                orders.getQuantity(),
                orders.getPrice());
    }
}
