package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Product;
import com.app.electronicserver.model.ProductCategory;
import com.app.electronicserver.repo.ProductRepo;
import com.app.electronicserver.service.ProductCategoryService;
import com.app.electronicserver.service.ProductImageService;
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
    private final ProductCategoryService productCategoryService;

    @Override
    public List<Product> getProductsByBrandId(Integer brandId) {
        return productRepo.getProductsByBrandId(brandId);
    }

    @Override
    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepo.getProductsByCategoryId(categoryId);
    }

    @Override
    public List<Product> findProductByKeywordsAndFilter(String keywords, String filter) {
        if (filter.equals("newest")) {
            return productRepo.findProductByKeywordsAndFilterTimeAsc(keywords);
        } else if (filter.equals("oldest")) {
            return productRepo.findProductByKeywordsAndFilterTimeDesc(keywords);
        } else if (filter.equals("lowest")) {
            return productRepo.findProductByKeywordsAndFilterPriceAsc(keywords);
        } else if (filter.equals("highest")) {
            return productRepo.findProductByKeywordsAndFilterPriceDesc(keywords);
        } else {
            return productRepo.findProductByKeywords(keywords);
        }
    }


    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByMinPriceAndMaxPrice(Double minPrice, Double maxPrice) {
        return productRepo.findProductByPriceBetween(minPrice, maxPrice);
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

    @Override
    public List<Product> getProductsByFilterUserUi(String search, List<String> pcName, List<String> color, Double minPrice, Double maxPrice, Boolean features, Boolean bestSeller) {
        if (pcName.size() == 0) {
            productCategoryService.getProductCategory()
                    .stream()
                    .map(ProductCategory::getName)
                    .forEach(pcName::add);
        }
        if (color.size() == 0) {
            productRepo.findAll()
                    .stream()
                    .map(Product::getColor)
                    .forEach(c -> {
                        if (!color.contains(c)) {
                            color.add(c);
                        }
                    });
        }



        return productRepo.getProductsByFilterUserUi('%' + search + '%', pcName, color, minPrice, maxPrice, features, bestSeller);
    }

    @Override
    public List<Product> getProductsByFilter(String search, String pcName, String bName, Date minDate, Date maxDate, Double maxPrice, boolean status, boolean features, boolean bestSeller) {
        return productRepo.getProductsByFilter('%' + search + '%', '%' + pcName + '%', '%' + bName + '%', minDate, maxDate, maxPrice, status, features, bestSeller);
    }
}
