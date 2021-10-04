package com.app.electronicserver.api;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.service.BrandService;
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
@RequestMapping("/api/brand")
public class BrandResource {
    private final BrandService BRAND_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<Brand>> getBrands() {
        return ResponseEntity.ok().body(BRAND_SERVICE.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrand(@PathVariable Integer id) {
        return ResponseEntity.ok().body(BRAND_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/brand/save").toUriString());
        brand.setCreated_at(new Date());
        brand.setUpdate_at(new Date());
        return ResponseEntity.created(uri).body(BRAND_SERVICE.saveBrand(brand));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable("id") Integer id, @RequestBody Brand brand) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/brand/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(BRAND_SERVICE.updateBrand(brand, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        BRAND_SERVICE.deleteBrand(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }

}
