package com.app.electronicserver.controller;

import com.app.electronicserver.model.Brand;
import com.app.electronicserver.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

//    @GetMapping("/")
//    private List<Brand> getAllBrand() {
//        return brandService.findAll();
//    }
//
//    @GetMapping("/{id}")
//	public Brand getOne(@PathVariable("id") Integer id) {
//		return brandService.findById(id);
//	}
//
//    @PostMapping("/")
//    public Brand PostBrand(@RequestBody Brand brand) {
//        brand.setCreated_at(new Date());
//        brand.setUpdate_at(new Date());
//        return brandService.create(brand);
//    }
//
//    @PutMapping("/{id}")
//    public Brand update(@PathVariable("id") Integer id, @RequestBody Brand brand) {
//        return brandService.update(brand);
//    }
}
