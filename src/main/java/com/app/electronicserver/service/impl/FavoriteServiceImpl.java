package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Favorite;
import com.app.electronicserver.repo.FavoriteRepo;
import com.app.electronicserver.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepo favoriteRepo;

    @Override
    public List<Favorite> getFavorite() {
        return favoriteRepo.findAll();
    }

    @Override
    public Favorite saveFavorite(Favorite favorite) {
        favorite.setCreated_at(new Date());
        return favoriteRepo.save(favorite);
    }

    @Override
    public Favorite updateFavorite(Favorite favorite, Integer id) {
        favorite.setId(id);
        return favoriteRepo.save(favorite);
    }

    @Override
    public void deleteFavorite(Integer id) {
        Favorite favorite = findById(id);
        favoriteRepo.delete(favorite);
    }

    @Override
    public Favorite findById(Integer id) {
        return favoriteRepo.findById(id).get();
    }
}
