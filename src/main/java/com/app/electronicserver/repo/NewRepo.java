package com.app.electronicserver.repo;

import com.app.electronicserver.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepo extends JpaRepository<News, Integer> {
}
