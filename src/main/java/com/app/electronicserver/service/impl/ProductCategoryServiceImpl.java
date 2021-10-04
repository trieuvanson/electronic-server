package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.ProductCategory;
import com.app.electronicserver.repo.ProductCategoryRepo;
import com.app.electronicserver.service.BrandService;
import com.app.electronicserver.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service @RequiredArgsConstructor
@Transactional
@Slf4j
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryRepo productCategoryRepo;
//    private final BrandService brandService;

    @Override
    public List<ProductCategory> getProductCategory() {
        return productCategoryRepo.findAll();
    }

    @Override
    public ProductCategory saveProductCategory(ProductCategory productCategory) {
        productCategory.setCreated_at(new Date());
        productCategory.setUpdate_at(new Date());
        return productCategoryRepo.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory, Integer id) {
        productCategory = findById(id);
        productCategory.setUpdate_at(new Date());
        return productCategoryRepo.save(productCategory);
    }

    @Override
    public void deleteBrand(Integer id) {
        ProductCategory productCategory = findById(id);
        productCategoryRepo.delete(productCategory);
    }

    @Override
    public ProductCategory findById(Integer id) {
        return productCategoryRepo.findById(id).get();
    }
}
