package com.codingrecipe.uigunlee.order.controller;

import com.codingrecipe.uigunlee.order.controller.request_form.CreateAllOrdersRequestForm;
import com.codingrecipe.uigunlee.order.controller.request_form.ListOrdersRequestForm;
import com.codingrecipe.uigunlee.order.controller.response_form.CreateAllOrdersResponseForm;
import com.codingrecipe.uigunlee.order.controller.response_form.ListOrdersResponseForm;
import com.codingrecipe.uigunlee.order.service.OrdersService;
import com.codingrecipe.uigunlee.order.service.request.CreateAllOrderItemRequest;
import com.codingrecipe.uigunlee.order.service.request.CreateAllOrdersRequest;
import com.codingrecipe.uigunlee.order.service.request.ListOrdersRequest;
import com.codingrecipe.uigunlee.order.service.response.CreateAllOrdersResponse;
import com.codingrecipe.uigunlee.order.service.response.ListOrdersResponse;
import com.codingrecipe.uigunlee.redis_cache.RedisCacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {

    final private OrdersService ordersService;
    final private RedisCacheService redisCacheService;

//    @PostMapping("/create")
//    public CreateOrdersResponseForm createOrders(
//            @RequestHeader("Authorization") String authorizationHeader,
//            @RequestBody CreateOrdersRequestForm requestForm) {
//
//        log.info("createOrders()");
//
//        String userToken = authorizationHeader.replace("Bearer ", "").trim();
//        Long accountId = redisCacheService.getValueByKey(userToken, Long.class);
//
//        CreateOrdersRequest request = requestForm.toCreateOrdersRequest(accountId);
//        CreateOrdersResponse response = ordersService.create(request);
//
//        return CreateOrdersResponseForm.from(response);
//    }

    @PostMapping("/create-all")
    public CreateAllOrdersResponseForm createAllOrders(
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody CreateAllOrdersRequestForm requestForm) {

        log.info("createAllOrders()");

        String userToken = authorizationHeader.replace("Bearer ", "").trim();
        Long accountId = redisCacheService.getValueByKey(userToken, Long.class);

        CreateAllOrdersRequest ordersRequest = requestForm.toCreateAllOrdersRequest(accountId);
        CreateAllOrderItemRequest orderItemRequest = requestForm.toCreateAllOrderItemRequest();
        CreateAllOrdersResponse response = ordersService.createAll(ordersRequest, orderItemRequest);

        return CreateAllOrdersResponseForm.from(response);
    }

    @GetMapping("/list")
    public ListOrdersResponseForm listOrders(
            @RequestHeader("Authorization") String authorizationHeader,
            @ModelAttribute ListOrdersRequestForm requestForm) {

        log.info("listOrders()");

        String userToken = authorizationHeader.replace("Bearer ", "").trim();
        Long accountId = redisCacheService.getValueByKey(userToken, Long.class);

        ListOrdersRequest request = requestForm.toListOrdersRequest(accountId);
        ListOrdersResponse response = ordersService.list(request);

        return ListOrdersResponseForm.from(response);
    }
}
