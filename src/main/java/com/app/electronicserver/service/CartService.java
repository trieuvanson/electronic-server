package com.app.electronicserver.service;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    List<CartItem> getCartItemsByUsername(String username);
    CartItem saveCartItem(CartItem cartItem);
    void removeCartByUsername(Integer cartId, String username);
    CartItem updateCartItem(CartItem cartItem, Integer id);

}
