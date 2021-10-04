package com.app.electronicserver.repo;

import com.app.electronicserver.model.New;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepo extends JpaRepository<New, Integer> {
}
