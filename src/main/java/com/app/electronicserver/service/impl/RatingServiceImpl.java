package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Rating;
import com.app.electronicserver.model.Rating;
import com.app.electronicserver.repo.RatingRepo;
import com.app.electronicserver.service.RatingService;
import com.app.electronicserver.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class RatingServiceImpl implements RatingService {
    private final RatingRepo ratingRepo;
    @Override
    public Rating findById(Integer id) {
        return ratingRepo.findById(id).orElse(null);
    }

    @Override
    public List<Rating> getRatingByUserUsername(String username) {
        return ratingRepo.getRatingByUserUsername(username);
    }

    @Override
    public Rating saveRating(Rating rating) {
        rating.setCreated_at(new Date());
        rating.setUpdated_at(new Date());
        return ratingRepo.save(rating);
    }

    @Override
    public void removeRatingByIdAndUserUsername(Integer id, String username) {
        ratingRepo.removeRatingByIdAndUserUsername(id, username);
    }

    @Override
    public Rating updateRating(Rating rating, Integer id) {
        rating.setId(id);
        rating.setUpdated_at(new Date());
        return saveRating(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserUsernameAndProductId(String username, Integer productId) {
        return ratingRepo.getRatingByUserUsernameAndProductId(username, productId);
    }

    @Override
    public List<Rating> getRatingByProductId(Integer productId) {
        return ratingRepo.getRatingByProductId(productId);
    }
}
