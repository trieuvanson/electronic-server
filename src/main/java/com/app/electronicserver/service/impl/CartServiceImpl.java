package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.repo.CartRepo;
import com.app.electronicserver.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CartServiceImpl implements CartService {
    private final CartRepo cartRepo;

    @Override
    public List<CartItem> getCartItemsByUsername(String username) {
        return cartRepo.getCartItemsByUsername(username);
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        cartItem.setCreated_at(new Date());
        return cartRepo.save(cartItem);
    }

    @Override
    public void removeCartByUsername(Integer cartId, String username) {
        cartRepo.deleteCartByIdAndUsername(cartId, username);
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem, Integer id) {
        cartItem.setId(id);
        return cartRepo.save(cartItem);
    }
}
