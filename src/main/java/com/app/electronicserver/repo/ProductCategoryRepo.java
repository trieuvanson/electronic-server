package com.app.electronicserver.repo;

import com.app.electronicserver.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {


    @Query("select p from ProductCategory p " +
            "inner join Brand b on p.brand.id = b.id " +
            "where p.name like :search and b.name like :brandName")
    List<ProductCategory> getProductCategoriesByFilter(@Param("search") String search, @Param("brandName") String brandName);
}
