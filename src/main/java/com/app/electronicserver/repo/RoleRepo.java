package com.app.electronicserver.repo;

import com.app.electronicserver.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, String> {
}
