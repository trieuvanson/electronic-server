package com.app.electronicserver.repo;

import com.app.electronicserver.model.Slide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlideRepo extends JpaRepository<Slide, Integer> {
}
