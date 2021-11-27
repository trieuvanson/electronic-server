package com.app.electronicserver.api;

import com.app.electronicserver.model.ProductCategory;
import com.app.electronicserver.service.BrandService;
import com.app.electronicserver.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/product-category")
public class ProductCategoryResource {
    private final ProductCategoryService PRODUCT_CATEGORY_SERVICE;
    private final BrandService brandService;

    @GetMapping("/")
    public ResponseEntity<List<ProductCategory>> getProductCategory() {
        return ResponseEntity.ok().body(PRODUCT_CATEGORY_SERVICE.getProductCategory());
    }

    @GetMapping("/filters")
    public ResponseEntity<List<ProductCategory>> getProductCategoriesByFilter(@RequestParam("search") String search,
                                                                              @RequestParam("brandName") String brandName) {
        return ResponseEntity.ok().body(PRODUCT_CATEGORY_SERVICE.getProductCategoriesByFilter(search, brandName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategory(@PathVariable Integer id) {
        return ResponseEntity.ok().body(PRODUCT_CATEGORY_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<ProductCategory> saveProductCategory(@RequestBody ProductCategory productCategory) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product-category/save").toUriString());
        return ResponseEntity.created(uri).body(PRODUCT_CATEGORY_SERVICE.saveProductCategory(productCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable("id") Integer id, @RequestBody ProductCategory productCategory) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product-category/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(PRODUCT_CATEGORY_SERVICE.updateProductCategory(productCategory, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        PRODUCT_CATEGORY_SERVICE.deleteBrand(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }

}
