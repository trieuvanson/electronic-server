package com.app.electronicserver.repo;

import com.app.electronicserver.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepo extends JpaRepository<Discount, String> {
}
