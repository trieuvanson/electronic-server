package com.app.electronicserver.repo;

import com.app.electronicserver.model.ProductCategory;
import com.app.electronicserver.reports.TopCategoriesByBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Integer> {


    @Query("select p from ProductCategory p " +
            "inner join Brand b on p.brand.id = b.id " +
            "where p.name like :search and b.name like :brandName")
    List<ProductCategory> getProductCategoriesByFilter(@Param("search") String search, @Param("brandName") String brandName);

    @Query("select new TopCategoriesByBrand(b.name, count(oddt), pc.name) from Order o " +
            "inner join OrderDetail oddt on o.id = oddt.order.id " +
            "inner join Product p on oddt.product.id = p.id " +
            "inner join ProductCategory pc on p.category.id = pc.id " +
            "inner join Brand b on pc.brand.id = b.id " +
            "where b.name like :bname " +
            "group by pc.name " +
            "order by count(oddt) desc")
    List<TopCategoriesByBrand> topCategoriesByBrand(@Param("bname") String bname);


}
