package com.app.electronicserver.repo;

import com.app.electronicserver.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite, Integer> {
}
