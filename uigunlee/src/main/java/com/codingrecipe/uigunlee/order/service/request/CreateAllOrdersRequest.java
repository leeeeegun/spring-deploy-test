package com.codingrecipe.uigunlee.order.service.request;

import com.codingrecipe.uigunlee.account.entity.Account;
import com.codingrecipe.uigunlee.order.entity.Orders;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateAllOrdersRequest {

    private final Long accountId;

    public Orders toOrders(Account account) {
        return new Orders(account);
    }
}
