package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.model.Comments;
import com.app.electronicserver.repo.AddressRepo;
import com.app.electronicserver.repo.CommentRepo;
import com.app.electronicserver.service.AddressService;
import com.app.electronicserver.service.CommentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CommentsServiceImpl implements CommentsService {
    private final CommentRepo commentRepo;
    @Override
    public Comments findById(Integer id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public List<Comments> getCommentsByUserUsername(String username) {
        return commentRepo.getCommentsByUserUsername(username);
    }

    @Override
    public Comments saveComments(Comments comments) {
        comments.setCreated_at(new Date());
        comments.setUpdated_at(new Date());
        return commentRepo.save(comments);
    }

    @Override
    public void removeCommentsByIdAndUserUsername(Integer id, String username) {
        commentRepo.removeCommentsByIdAndUserUsername(id, username);
    }

    @Override
    public Comments updateComments(Comments comments, Integer id) {
        comments.setId(id);
        comments.setUpdated_at(new Date());
        return commentRepo.save(comments);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Comments::getCreated_at).reversed()).
                collect(Collectors.toList());
    }

    @Override
    public List<Comments> getCommentsByUserUsernameAndProductId(String username, Integer productId) {
        return commentRepo.getCommentsByUserUsernameAndProductId(username, productId);
    }

    @Override
    public List<Comments> getCommentsByProductId(Integer productId) {
        return commentRepo.getCommentsByProductId(productId);
    }
}
