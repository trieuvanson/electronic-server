package com.app.electronicserver.service;

import com.app.electronicserver.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order findById(Long id);
    List<Order> getOrdersByUsername(String username);
    Order saveOrder(Order order);
    void removeOrderByIdAndUsername(Long orderId, String username);
    Order updateOrders(Order order, Long id);
    Order saveOrderDetails(Order order);
}
