package com.app.electronicserver.service;

import com.app.electronicserver.model.Discount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DiscountService {
    Discount getDiscount(String code);
    List<Discount> getAllDiscounts();
}
