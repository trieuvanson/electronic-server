package com.app.electronicserver.repo;

import com.app.electronicserver.model.Order;
import com.app.electronicserver.reports.OrderRevenueByMothnAndYear;
import com.app.electronicserver.reports.RevenueByYear;
import com.app.electronicserver.reports.TotalAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "select order from Order order where order.user.username=:username")
    List<Order> getOrdersByUsername(@Param("username") String username);

    @Query(value = "select o from Order o inner join Address a on o.address.id=a.id " +
            "where a.fullname like :fullname and o.status like :status and o.payment like :payment and o.total between 0 and :max and o.created_at between :minDate and :maxDate")
    List<Order> getOrdersByFilter(@Param("fullname") String fullname, @Param("status") String status, @Param("payment") String payment, @Param("max") Double max, @Param("minDate") Date minDate, @Param("maxDate") Date maxDate);

    @Query(value = "select new OrderRevenueByMothnAndYear(month(o.created_at), count(oddt), sum(o.total)) " +
            "from Order o " +
            "inner join OrderDetail oddt on o.id = oddt.order.id " +
            "inner join Product p on oddt.product.id = p.id " +
            "where year(o.created_at) = :year and o.status like '%Đã nhận hàng%' " +
            "group by month(o.created_at)")
    List<OrderRevenueByMothnAndYear> getOrderRevenueByMonthAndYear(Integer year);

    @Query("select new RevenueByYear(month(o.created_at), sum(o.total)) from Order o " +
            "where year(o.created_at) = :year and o.status like '%Đã nhận hàng%' " +
            "group by month(o.created_at)")
    List<RevenueByYear> getRevenueByYear(@Param("year") Integer year);

    @Query("select new TotalAndName('Khách hàng',sum(o.total), u.fullname) from Order o " +
            "inner join User u on o.user.username like u.username where o.status like '%Đã nhận hàng%' " +
            "group by u.fullname")
    List<TotalAndName> getTopByUser();



}
