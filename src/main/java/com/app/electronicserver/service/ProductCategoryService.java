package com.app.electronicserver.service;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductCategoryService {
    List<ProductCategory> getProductCategory();

    ProductCategory saveProductCategory(ProductCategory productCategory);

    ProductCategory updateProductCategory(ProductCategory productCategory, Integer id);

    void deleteBrand(Integer id);

    ProductCategory findById(Integer id);
}
