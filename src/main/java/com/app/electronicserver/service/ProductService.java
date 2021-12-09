package com.app.electronicserver.service;

import com.app.electronicserver.model.Product;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ProductService {


    List<Product> getProductsByBrandId(Integer brandId);

    List<Product> getProductsByCategoryId(Integer categoryId);
    List<Product> findProductByKeywordsAndFilter(String keywords, String filter);
    List<Product> getProducts();
    List<Product> getProductsByMinPriceAndMaxPrice(Double minPrice, Double maxPrice);
    Product saveProduct(Product product);

    Product updateProduct(Product product, Integer id);

    void deleteProduct(Integer id);

    Product findById(Integer id);

    List<Product> getProductsByFilterUserUi(String search, List<String> pcName, List<String> color,
                                            Double minPrice, Double maxPrice, Boolean features, Boolean bestSeller);

    List<Product> getProductsByFilter(String search, String pcName, String bName,
                                      Date minDate, Date maxDate, Double maxPrice,
                                      boolean status, boolean features, boolean bestSeller);
}
