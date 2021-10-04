package com.app.electronicserver.repo;

import com.app.electronicserver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
