package com.app.electronicserver.service;

import com.app.electronicserver.model.Product;
import com.app.electronicserver.model.ProductImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductImageService {
    List<ProductImage> getProductimage();

    ProductImage saveProductimage(ProductImage productImage);

    ProductImage updateProductimage(ProductImage productImage, Integer id);

    void deleteProductimage(Integer id);

    ProductImage findById(Integer id);
}
