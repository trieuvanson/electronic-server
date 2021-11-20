package com.app.electronicserver.repo;

import com.app.electronicserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {


    @Query("select p from Product p inner join ProductCategory pc on p.category.id = pc.id inner join Brand b on b.id = pc.brand.id where b.id=:brandId")
    List<Product> getProductsByBrandId(Integer brandId);
    @Query("select p from Product p inner join ProductCategory pc on p.category.id = pc.id where pc.id=:categoryId")
    List<Product> getProductsByCategoryId(Integer categoryId);
    @Query("select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords")
    List<Product> findProductByKeywords(@Param("keywords") String keywords);
}
