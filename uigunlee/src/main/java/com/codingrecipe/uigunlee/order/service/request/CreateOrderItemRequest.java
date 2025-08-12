package com.codingrecipe.uigunlee.order.service.request;

import com.codingrecipe.uigunlee.book.entity.Book;
import com.codingrecipe.uigunlee.order.entity.OrderItem;
import com.codingrecipe.uigunlee.order.entity.Orders;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateOrderItemRequest {
    final private Long bookId;
    final private Long quantity;
    final private Long price;

    public OrderItem toOrderItem(Book book, Orders orders) {
        return new OrderItem(book, quantity, price, orders);
    }
}
