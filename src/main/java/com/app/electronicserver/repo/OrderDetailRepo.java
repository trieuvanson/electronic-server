package com.app.electronicserver.repo;

import com.app.electronicserver.model.OrderDetail;
import com.app.electronicserver.reports.QuantityAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
    @Query("Select oddt from OrderDetail oddt where oddt.order.id=:orderId")
    List<OrderDetail> getOrderDetailsByOrderId(@Param("orderId") Long orderId);
    @Query("Select new QuantityAndName(b.name, count(oddt), b.name) from OrderDetail oddt " +
            "inner join Product p on oddt.product.id=p.id " +
            "inner join Order o on oddt.order.id=o.id " +
            "inner join ProductCategory pc on p.category.id=pc.id " +
            "inner join Brand b on pc.brand.id=b.id where o.status like '%Đã nhận hàng%' " +
            "group by b.id")
    List<QuantityAndName> getQuantityAndNameFormOrderDetail();
}

