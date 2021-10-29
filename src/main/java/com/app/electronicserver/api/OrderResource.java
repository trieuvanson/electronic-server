package com.app.electronicserver.api;

import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.Order;
import com.app.electronicserver.service.CartService;
import com.app.electronicserver.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
