package com.finleap.oms.services;

import com.finleap.oms.models.Order;
import java.util.List;


public interface OrderService {
    List<Order> findAll();

    List<Order> findByCustomerId(String customerId);

    void addOrder(Order order);

    void completeOrder(String orderId);

    void cancelOrder(String orderId);
}
