package com.app.electronicserver.service;

import com.app.electronicserver.model.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    List<Brand> getUsers();

    Brand saveBrand(Brand brand);

    Brand updateBrand(Brand brand, Integer id);

    void deleteBrand(Integer id);

    Brand findById(Integer id);

}
