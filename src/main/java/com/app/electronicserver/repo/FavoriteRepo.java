package com.app.electronicserver.repo;

import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {
    @Query(value = "select favorite from Favorite favorite where favorite.user.username=:username")
    List<Favorite> getFavoritesByUsername(@Param("username") String username);
    @Query("Select favorite  FROM Favorite favorite WHERE favorite.product.id= :product_id and favorite.user.username=:username")
    Optional<Favorite> getFavoriteByProductIdAndUsername(@Param("product_id") Integer product_id, @Param("username") String username);
    @Modifying
    @Transactional
    @Query("DELETE  FROM Favorite favorite WHERE favorite.id =:id and favorite.user.username=:username")
    void deleteFavoriteByIdAndUsername(@Param("id") Integer id, @Param("username") String username);
}
