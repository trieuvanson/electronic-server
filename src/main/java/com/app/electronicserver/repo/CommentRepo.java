package com.app.electronicserver.repo;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CommentRepo extends JpaRepository<Comments, Integer> {

    @Query(value = "select comments from Comments comments where comments.user.username=:username")
    List<Comments> getCommentsByUserUsername(@Param("username") String username);
    @Query(value = "select comments from Comments comments where comments.user.username=:username and comments.product.id=:productId")
    List<Comments> getCommentsByUserUsernameAndProductId(@Param("username") String username, @Param("productId") Integer productId);
    List<Comments> getCommentsByProductId(Integer productId);
    @Modifying
    @Transactional
    @Query("DELETE FROM Comments comments WHERE comments.id =:id and comments.user.username=:username")
    void removeCommentsByIdAndUserUsername(@Param("id") Integer id, @Param("username") String username);
}
