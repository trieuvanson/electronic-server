package com.app.electronicserver.api;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.User;
import com.app.electronicserver.service.BrandService;
import com.app.electronicserver.service.CartService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartResource {
    private final CartService cartService;

    @GetMapping("/")
    public ResponseEntity<List<CartItem>> getCartItemsByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok().body(cartService.getCartItemsByUsername(username));
    }

    @PostMapping("/")
    public ResponseEntity<CartItem> saveCartItem(@RequestBody CartItem cartItem) {
        return ResponseEntity.ok().body(cartService.saveCartItem(cartItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem, @PathVariable Integer id) {
        return ResponseEntity.ok().body(cartService.updateCartItem(cartItem, id));
    }

    @DeleteMapping("/{id}&{username}")
    public ResponseEntity<Map<String, Boolean>> deleteCartItem(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        cartService.removeCartByUsername(id, username);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
//
//    @PostMapping("/")
//    public ResponseEntity<CartItem> saveCartItem(@RequestBody CartItem cartItem) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/brand/save").toUriString());
//        return ResponseEntity.created(uri).body(cartService.saveCartItem(cartItem));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<CartItem> updateCartItem(@PathVariable("id") Integer id, @RequestBody CartItem cartItem) {
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/brand/update/{id}").toUriString());
//        return ResponseEntity.created(uri).body(cartService.updateCartItem(cartItem, id));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteCartItem(@PathVariable("id") Integer id) {
//        cartService.deleteCartItem(id);
//        Map<String, Boolean> reponse = new HashMap<>();
//        reponse.put("DELETE", Boolean.TRUE);
//        return ResponseEntity.ok(reponse);
//    }

}
