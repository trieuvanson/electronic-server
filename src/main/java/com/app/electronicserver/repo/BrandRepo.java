package com.app.electronicserver.repo;

import com.app.electronicserver.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BrandRepo extends JpaRepository<Brand, Integer> {

    @Query("select b from Brand b where b.name like ?1")
    List<Brand> findByBrandsName(String brandName);
}
