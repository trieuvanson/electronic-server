package com.app.electronicserver.repo;

import com.app.electronicserver.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepo extends JpaRepository<ProductImage, Integer> {
}
