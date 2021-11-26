package com.app.electronicserver.repo;

import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "select order from Order order where order.user.username=:username")
    List<Order> getOrdersByUsername(@Param("username") String username);

    @Query(value = "select o from Order o inner join Address a on o.address.id=a.id " +
            "where a.fullname like :fullname and o.status like :status and o.payment like :payment and o.total between 0 and :max and o.created_at between :minDate and :maxDate")
    List<Order> getOrdersByFilter(@Param("fullname") String fullname, @Param("status") String status, @Param("payment") String payment, @Param("max") Double max, @Param("minDate") Date minDate, @Param("maxDate") Date maxDate);


}
