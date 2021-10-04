package com.app.electronicserver.repo;

import com.app.electronicserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
