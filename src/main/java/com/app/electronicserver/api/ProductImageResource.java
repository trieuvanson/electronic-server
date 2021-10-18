package com.app.electronicserver.api;

import com.app.electronicserver.model.ProductImage;
import com.app.electronicserver.service.ProductImageService;
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
@RequestMapping("/api/product-image")
public class ProductImageResource {
    private final ProductImageService PRODUCT_IMAGE_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<ProductImage>> getProductImages() {
        return ResponseEntity.ok().body(PRODUCT_IMAGE_SERVICE.getProductimage());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductImage> getProductImage(@PathVariable Integer id) {
        return ResponseEntity.ok().body(PRODUCT_IMAGE_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<ProductImage> saveProductImage(@RequestBody ProductImage productImage) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product-image/save").toUriString());
        return ResponseEntity.created(uri).body(PRODUCT_IMAGE_SERVICE.saveProductimage(productImage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductImage> updateProductImage(@PathVariable("id") Integer id, @RequestBody ProductImage productImage) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product-image/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(PRODUCT_IMAGE_SERVICE.updateProductimage(productImage, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        PRODUCT_IMAGE_SERVICE.deleteProductimage(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }

}
