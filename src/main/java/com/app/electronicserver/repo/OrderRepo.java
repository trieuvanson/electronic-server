package com.app.electronicserver.repo;

import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "select order from Order order where order.user.username=:username")
    List<Order> getOrdersByUsername(@Param("username") String username);
//    @Modifying
//    @Transactional
//    @Query("DELETE  FROM Order order WHERE order.id =:id and order.user.username=:username")
//    void deleteOrderIdAndUsername(@Param("id") Integer id, @Param("username") String username);
//    @Modifying
//    @Transactional
//    @Query("DELETE FROM Order order WHERE order.user.username=:username")
//    void deleteOrdersByUsername(@Param("username") String username);
}
