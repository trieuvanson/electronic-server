package com.app.electronicserver.repo;

import com.app.electronicserver.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
    @Query("Select oddt from OrderDetail oddt where oddt.order.id=:orderId")
    List<OrderDetail> getOrderDetailsByOrderId(@Param("orderId") Long orderId);

}
