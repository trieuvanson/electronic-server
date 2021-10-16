package com.app.electronicserver.service;

import com.app.electronicserver.model.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {
    List<Favorite> getFavorite();

    Favorite saveFavorite(Favorite favorite);

    Favorite updateFavorite(Favorite favorite, Integer id);

    void deleteFavorite(Integer id);

    Favorite findById(Integer id);
}
