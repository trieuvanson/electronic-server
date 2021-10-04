package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.repo.BrandRepo;
import com.app.electronicserver.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandRepo brandRepo;

    @Override
    public List<Brand> getUsers() {
        return brandRepo.findAll();
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandRepo.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand, Integer id) {
        brand = findById(id);
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
