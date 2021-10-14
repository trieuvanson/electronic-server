package com.app.electronicserver.repo;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends JpaRepository<CartItem, Integer> {
    @Query(value = "select cartItem from CartItem cartItem where cartItem.user.username=:username")
    List<CartItem> getCartItemsByUsername(@Param("username") String username);
    @Query("Select cartItem  FROM CartItem cartItem WHERE cartItem.product.id= :product_id and cartItem.user.username=:username")
    Optional<CartItem> getCartItemByProductIdAndUsername(@Param("product_id") Integer product_id, @Param("username") String username);
    @Modifying
    @Transactional
    @Query("DELETE  FROM CartItem cartItem WHERE cartItem.id =:id and cartItem.user.username=:username")
    void deleteCartByIdAndUsername(@Param("id") Integer id, @Param("username") String username);
}
