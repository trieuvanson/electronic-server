package com.app.electronicserver.api;

import com.app.electronicserver.model.Order;
import com.app.electronicserver.model.OrderDetail;
import com.app.electronicserver.reports.QuantityAndName;
import com.app.electronicserver.service.OrderService;
import com.app.electronicserver.service.ReportService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/order")
public class OrderResource {
    private final OrderService orderService;
    @GetMapping("")
    public ResponseEntity<List<Order>> getOrdersByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok().body(orderService.getOrdersByUsername(username));
    }

    @GetMapping("/filters")
    public ResponseEntity<List<Order>> getOrdersByFilter(@RequestParam("fullname") String fullname,
                                                         @RequestParam("status") String status,
                                                         @RequestParam("payment") String payment,
                                                         @RequestParam("max") Double max,
                                                         @RequestParam("minDate") Date minDate,
                                                         @RequestParam("maxDate") Date maxDate) {
        return ResponseEntity.ok().body(orderService.getOrdersByFilter(fullname, status, payment, max, minDate, maxDate));
    }

    @GetMapping("/")
    public ResponseEntity<List<Order>> getAll(@RequestParam("field") String field) {
        return ResponseEntity.ok().body(orderService.getAll(Sort.by(Sort.Direction.DESC, field)));
    }



    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @GetMapping("/order-details/{orderId}")
    public ResponseEntity<List<OrderDetail>> getOrderDetailsByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok().body(orderService.getOrderDetailsByOrderId(orderId));
    }

    @GetMapping("/order-details/")
    public ResponseEntity<List<OrderDetail>> getOrderDetails() {
        return ResponseEntity.ok().body(orderService.getOrderDetails());
    }


    @PostMapping("/")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.saveOrder(order));
    }

    @PostMapping("/order-details/")
    public ResponseEntity<Order> saveOrderDetails(@RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.saveOrderDetails(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.updateOrders(order, id));
    }

    @DeleteMapping("/{id}&{username}")
    public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable("id") Long id, @PathVariable("username") String username) {
        orderService.removeOrderByIdAndUsername(id, username);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }

}

