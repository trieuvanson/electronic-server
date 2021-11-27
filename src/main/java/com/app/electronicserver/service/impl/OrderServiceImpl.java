package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.Order;
import com.app.electronicserver.model.OrderDetail;
import com.app.electronicserver.repo.CartRepo;
import com.app.electronicserver.repo.DiscountRepo;
import com.app.electronicserver.repo.OrderDetailRepo;
import com.app.electronicserver.repo.OrderRepo;
import com.app.electronicserver.reports.OrderRevenueByMothnAndYear;
import com.app.electronicserver.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderDetailRepo orderDetailRepo;
    private final CartRepo cartRepo;
    private final DiscountRepo discountRepo;
    @Override
    public Order findById(Long id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public List<Order> getAll(Sort sort) {
        return orderRepo.findAll(sort);
    }


    @Override
    public List<Order> getOrdersByUsername(String username) {
        return orderRepo.getOrdersByUsername(username);
    }

    @Override
    public Order saveOrder(Order order) {
        try {
            order.setCreated_at(new Date());
            order.setUpdate_at(new Date());
            if (order.getDiscount() != null) {

            }
            return orderRepo.save(order);
        } catch (Exception e) {
            throw new RuntimeException("Lỗi ", e);
        }
    }


    @Override
    public void removeOrderByIdAndUsername(Long orderId, String username) {

    }

    @Override
    public Order updateOrders(Order order, Long id) {
        order.setId(id);
        System.out.println(new Date());
        order.setUpdate_at(new Date());
        order.setStatus("Mới đặt");
        return orderRepo.save(order);
    }


    @Override
    public Order saveOrderDetails(Order order) {
        try {
            List<CartItem> cart = cartRepo.getCartItemsByUsername(order.getUser().getUsername());
            cart.forEach(c -> {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(order);
                    orderDetail.setPrice(c.getProduct().getSale_price());
                    orderDetail.setQuantity(c.getQuantity());
                    orderDetail.setProduct(c.getProduct());
                    orderDetailRepo.save(orderDetail);
            });
            cartRepo.deleteAllCartByUsername(order.getUser().getUsername());
        } catch (Exception e) {
            throw new RuntimeException("Lỗi ", e);
        }
        return orderRepo.save(order);
    }

    @Override
    public List<OrderDetail> getOrderDetailsByOrderId(Long orderId) {
        return orderDetailRepo.getOrderDetailsByOrderId(orderId);
    }

    @Override
    public List<OrderDetail> getOrderDetails() {
        return orderDetailRepo.findAll();
    }

    @Override
    public List<Order> getOrdersByFilter(String fullname, String status, String payment, Double max, Date minDate, Date maxDate) {
        System.out.println(fullname + " " + status + " " + payment + " " + max + " " + minDate + " " + maxDate);
        return orderRepo.getOrdersByFilter('%' + fullname + '%', '%' + status + '%', '%' + payment + '%', max, minDate, maxDate);
    }

}
