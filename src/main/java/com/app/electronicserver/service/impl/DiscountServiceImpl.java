package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Discount;
import com.app.electronicserver.repo.DiscountRepo;
import com.app.electronicserver.service.DiscountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepo discountRepo;

    @Override
    public Discount getDiscount(String code) {
        return discountRepo.findById(code).orElse(null);
    }
}
