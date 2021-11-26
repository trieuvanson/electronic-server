package com.app.electronicserver.api;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.model.Discount;
import com.app.electronicserver.service.BrandService;
import com.app.electronicserver.service.DiscountService;
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
@RequestMapping("/api/discount")
public class DiscountRecource {
    private final DiscountService discountService;

    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscountByCode(@PathVariable String id) {
        return ResponseEntity.ok().body(discountService.getDiscount(id));
    }

}
