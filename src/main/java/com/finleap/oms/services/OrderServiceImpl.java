package com.finleap.oms.services;
import com.finleap.oms.models.Order;
import com.finleap.oms.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findByCustomerId(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void completeOrder(String orderId) {
        orderRepository.completeOrder(orderId);
    }

    @Override
    public void cancelOrder(String orderId) {
        orderRepository.cancelOrder(orderId);
    }
}
