package com.codingrecipe.uigunlee.order.repository;

import com.codingrecipe.uigunlee.order.entity.OrderItem;
import com.codingrecipe.uigunlee.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrdersIn(Collection<Orders> orders);
}
