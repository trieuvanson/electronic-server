package com.app.electronicserver.repo;

import com.app.electronicserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {


    @Query("select p from Product p inner join ProductCategory pc on p.category.id = pc.id inner join Brand b on b.id = pc.brand.id where b.id=:brandId")
    List<Product> getProductsByBrandId(Integer brandId);

    @Query("select p from Product p inner join ProductCategory pc on p.category.id = pc.id where pc.id=:categoryId")
    List<Product> getProductsByCategoryId(Integer categoryId);

    @Query("select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords " +
            "order by p.created_at asc")
    List<Product> findProductByKeywordsAndFilterTimeAsc(@Param("keywords") String keywords);

    @Query("select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords " +
            "order by p.created_at desc ")
    List<Product> findProductByKeywordsAndFilterTimeDesc(@Param("keywords") String keywords);

    @Query("select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords " +
            "order by p.sale_price desc ")
    List<Product> findProductByKeywordsAndFilterPriceDesc(@Param("keywords") String keywords);

    @Query("select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords " +
            "order by p.sale_price asc")
    List<Product> findProductByKeywordsAndFilterPriceAsc(@Param("keywords") String keywords);

    @Query("select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords")
    List<Product> findProductByKeywords(@Param("keywords") String keywords);
    @Query("select p from Product p where p.sale_price between :min and :max order by p.sale_price asc ")
    List<Product> findProductByPriceBetween(@Param("min") double min, @Param("max") double max);

    @Query(value = "select p from Product p\n" +
            "    inner join ProductCategory pc on pc.id = p.category.id\n" +
            "    inner join Brand b on pc.brand.id = b.id\n" +
            "where p.name like :keywords or pc.name like :keywords or b.name like :keywords " +
            "order by :field asc")
    List<Product> findProductByKeywords(@Param("keywords") String keywords, @Param("field") String field);

    @Query("select p from Product p " +
            "inner join ProductCategory pc on p.category.id = pc.id " +
            "inner join Brand b on b.id = pc.brand.id " +
            "where p.name like :search and pc.name like :pcName and b.name like :bName " +
            "and p.created_at between :minDate and :maxDate " +
            "and p.sale_price between 0 and :maxPrice and p.status = :status and p.features = :features and p.best_seller = :best_seller")
    List<Product> getProductsByFilter(@Param("search") String search, @Param("pcName") String pcName,
                                      @Param("bName") String bName, @Param("minDate") Date minDate,
                                      @Param("maxDate") Date maxDate, @Param("maxPrice") double maxPrice,
                                      @Param("status") boolean status, @Param("features") boolean features,
                                      @Param("best_seller") boolean best_seller);

}
