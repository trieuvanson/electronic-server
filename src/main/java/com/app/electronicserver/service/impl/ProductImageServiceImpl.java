package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.ProductImage;
import com.app.electronicserver.repo.ProductImageRepo;
import com.app.electronicserver.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductImageServiceImpl implements ProductImageService {
    private final ProductImageRepo productImageRepo;

    @Override
    public List<ProductImage> getProductimage() {
        return productImageRepo.findAll();
    }

    @Override
    public ProductImage saveProductimage(ProductImage productImage) {
        productImage.setCreated_at(new Date());
        productImage.setUpdate_at(new Date());
        return productImageRepo.save(productImage);
    }

    @Override
    public ProductImage updateProductimage(ProductImage productImage, Integer id) {
        productImage.setId(id);
        productImage.setUpdate_at(new Date());
        return productImageRepo.save(productImage);
    }

    @Override
    public void deleteProductimage(Integer id) {
        ProductImage productImage = findById(id);
        productImageRepo.delete(productImage);
    }

    @Override
    public ProductImage findById(Integer id) {
        return productImageRepo.findById(id).get();
    }
}
