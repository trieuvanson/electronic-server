package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Product;
import com.app.electronicserver.repo.ProductRepo;
import com.app.electronicserver.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<Product> getProduct() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        product.setCreated_at(new Date());
        product.setUpdate_at(new Date());
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product, Integer id) {
        product.setId(id);
        product.setUpdate_at(new Date());
        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = findById(id);
        productRepo.delete(product);
    }

    @Override
    public Product findById(Integer id) {
        return productRepo.findById(id).get();
    }
}
