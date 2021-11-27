package com.app.electronicserver.api;

import com.app.electronicserver.model.Product;
import com.app.electronicserver.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductResource {
    private final ProductService PRODUCT_SERVICE;
    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.getProducts());
    }

    @GetMapping("/filters")
    public ResponseEntity<List<Product>> getProductsByFilter(@RequestParam("search") String search, @RequestParam("pcname") String pcname,
                                                             @RequestParam("bname") String bname, @RequestParam("minDate") Date minDate,
                                                             @RequestParam("maxDate") Date maxDate, @RequestParam("maxPrice") Double maxPrice,
                                                             @RequestParam("status") boolean status, @RequestParam("features") boolean features,
                                                             @RequestParam("bestSeller") boolean bestSeller)
    {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.getProductsByFilter(search, pcname, bname, minDate, maxDate, maxPrice, status, features, bestSeller));
    }
    @GetMapping("")
    public ResponseEntity<List<Product>> findProductByKeywords(@RequestParam("timkiem") String timkiem,
                                                               @RequestParam("filter") String filter) {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.findProductByKeywordsAndFilter('%' + timkiem + '%', filter));
    }

    @GetMapping("/price")
    public ResponseEntity<List<Product>> getProductsByMinPriceAndMaxPrice(@RequestParam("min") Double min,
                                                               @RequestParam("max") Double max) {
        return ResponseEntity.ok().body(PRODUCT_SERVICE.getProductsByMinPriceAndMaxPrice(min, max));
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
