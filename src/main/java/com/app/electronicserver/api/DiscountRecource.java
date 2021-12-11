package com.app.electronicserver.api;

import com.app.electronicserver.model.Discount;
import com.app.electronicserver.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/discount")
public class DiscountRecource {
    private final DiscountService discountService;

    @GetMapping
    public ResponseEntity<Iterable<Discount>> getAllDiscounts() {
        return ResponseEntity.ok().body(discountService.getAllDiscounts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Discount> getDiscountByCode(@PathVariable String id) {
        return ResponseEntity.ok().body(discountService.getDiscount(id));
    }

}
