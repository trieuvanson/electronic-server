package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.repo.BrandRepo;
import com.app.electronicserver.service.BrandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service @RequiredArgsConstructor
@Transactional
@Slf4j
public class BrandServiceImpl implements BrandService {
    private final BrandRepo brandRepo;

    @Override
    public List<Brand> getBrand() {
        return brandRepo.findAll();
    }

    @Override
    public Brand saveBrand(Brand brand) {
        brand.setCreated_at(new Date());
        brand.setUpdate_at(new Date());
        return brandRepo.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand, Integer id) {
        brand.setId(id);
        brand.setUpdate_at(new Date());
        return brandRepo.save(brand);
    }

    @Override
    public void deleteBrand(Integer id) {
        Brand brand = findById(id);
        brandRepo.delete(brand);
    }

    @Override
    public Brand findById(Integer id) {
        return brandRepo.findById(id).get();
    }
}
