package com.app.electronicserver.service;

import com.app.electronicserver.model.CartItem;
import com.app.electronicserver.model.Favorite;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteService {
    List<Favorite> getFavoritesByUsername(String username);
    Favorite saveFavorite(Favorite favorite);
    void removeFavoriteByUsername(Integer id, String username);
    Favorite updateFavorite(Favorite favorite, Integer id);
}
