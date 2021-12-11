package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Discount;
import com.app.electronicserver.repo.DiscountRepo;
import com.app.electronicserver.service.DiscountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepo discountRepo;

    @Override
    public Discount getDiscount(String code) {
        return discountRepo.findById(code).stream()
                .filter(discount -> discount.getDiscount_status() &&
                        discount.getExpired_at().getTime() > new Date().getTime() &&
                        discount.getTotal() > 0)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return discountRepo.findAll()
                .stream()
                .sorted((o1, o2) -> o2.getCreated_at().compareTo(o1.getCreated_at()))
                .collect(Collectors.toList());
    }
}
