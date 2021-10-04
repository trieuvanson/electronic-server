package com.app.electronicserver.service;

import com.app.electronicserver.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getProduct();

    Product saveProduct(Product product);

    Product updateProduct(Product product, Integer id);

    void deleteProduct(Integer id);

    Product findById(Integer id);
}
