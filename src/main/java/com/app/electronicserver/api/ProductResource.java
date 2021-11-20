package com.app.electronicserver.api;

import com.app.electronicserver.model.Product;
import com.app.electronicserver.service.ProductService;
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
@RequestMapping("/api/product")
public class ProductResource {
    private final ProductService PRODUCT_SERVICE;
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.getProducts());
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> findProductByKeywords(@RequestParam("timkiem") String timkiem) {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.findProductByKeywords('%' + timkiem + '%'));
    }
    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<Product>> getProductsByBrandId(@PathVariable Integer brandId) {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.getProductsByBrandId(brandId));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Integer categoryId) {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.getProductsByCategoryId(categoryId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product/save").toUriString());
        return ResponseEntity.created(uri).body(PRODUCT_SERVICE.saveProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(PRODUCT_SERVICE.updateProduct(product, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        PRODUCT_SERVICE.deleteProduct(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
