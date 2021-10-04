package com.app.electronicserver.repo;

import com.app.electronicserver.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {
}
