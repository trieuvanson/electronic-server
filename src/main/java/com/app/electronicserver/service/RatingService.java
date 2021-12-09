package com.app.electronicserver.service;

import com.app.electronicserver.model.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    Rating findById(Integer id);
    List<Rating> getRatingByUserUsername(String username);
    Rating saveRating(Rating rating);
    void removeRatingByIdAndUserUsername(Integer id, String username);
    Rating updateRating(Rating rating, Integer id);
    List<Rating> getAllRating();
    List<Rating> getRatingByUserUsernameAndProductId(String username, Integer productId);
    List<Rating> getRatingByProductId(Integer productId);
}
