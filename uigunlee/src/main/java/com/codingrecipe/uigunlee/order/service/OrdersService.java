package com.codingrecipe.uigunlee.order.service;

import com.codingrecipe.uigunlee.order.service.request.CreateAllOrderItemRequest;
import com.codingrecipe.uigunlee.order.service.request.CreateAllOrdersRequest;
import com.codingrecipe.uigunlee.order.service.request.ListOrdersRequest;
import com.codingrecipe.uigunlee.order.service.response.CreateAllOrdersResponse;
import com.codingrecipe.uigunlee.order.service.response.ListOrdersResponse;

public interface OrdersService {
    CreateAllOrdersResponse createAll(
            CreateAllOrdersRequest ordersRequest,
            CreateAllOrderItemRequest orderItemRequest);

    ListOrdersResponse list(ListOrdersRequest request);
}
