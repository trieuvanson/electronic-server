package com.app.electronicserver.repo;

import com.app.electronicserver.model.Rating;
import com.app.electronicserver.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RatingRepo extends JpaRepository<Rating, Integer> {

    @Query(value = "select rating from Rating rating where rating.user.username=:username")
    List<Rating> getRatingByUserUsername(@Param("username") String username);
    @Query(value = "select rating from Rating rating where rating.user.username=:username and rating.product.id=:productId")
    List<Rating> getRatingByUserUsernameAndProductId(@Param("username") String username, @Param("productId") Integer productId);
    List<Rating> getRatingByProductId(Integer productId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Rating rating WHERE rating.id =:id and rating.user.username=:username")
    void removeRatingByIdAndUserUsername(@Param("id") Integer id, @Param("username") String username);
}
