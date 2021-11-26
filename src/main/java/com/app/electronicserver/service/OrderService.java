package com.app.electronicserver.service;

import com.app.electronicserver.model.Order;
import com.app.electronicserver.model.OrderDetail;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {
    Order findById(Long id);
    List<Order> getAll(Sort sort);
    List<Order> getOrdersByUsername(String username);
    Order saveOrder(Order order);
    void removeOrderByIdAndUsername(Long orderId, String username);
    Order updateOrders(Order order, Long id);
    Order saveOrderDetails(Order order);
    List<OrderDetail> getOrderDetailsByOrderId(Long orderId);
    List<OrderDetail> getOrderDetails();
    List<Order> getOrdersByFilter(String fullname, String status, String payment, Double max, Date minDate, Date maxDate);
}
