package com.app.electronicserver.service;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.model.Comments;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentsService {
    Comments findById(Integer id);
    List<Comments> getCommentsByUserUsername(String username);
    Comments saveComments(Comments comments);
    void removeCommentsByIdAndUserUsername(Integer id, String username);
    Comments updateComments(Comments comments, Integer id);
    List<Comments> getAllComments();
    List<Comments> getCommentsByUserUsernameAndProductId(String username, Integer productId);
    List<Comments> getCommentsByProductId(Integer productId);
}
