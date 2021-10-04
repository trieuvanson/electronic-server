package com.app.electronicserver.repo;

import com.app.electronicserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
}
