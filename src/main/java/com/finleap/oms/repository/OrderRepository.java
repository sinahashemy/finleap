package com.finleap.oms.repository;
import com.finleap.oms.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String>{

    List<Order> findByCustomerId(String customerId);
    void cancelOrder(String orderId);
    void completeOrder(String orderId);
}
