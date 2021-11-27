package com.app.electronicserver.api;

import com.app.electronicserver.model.Order;
import com.app.electronicserver.model.Slide;
import com.app.electronicserver.reports.OrderRevenueByMothnAndYear;
import com.app.electronicserver.reports.QuantityAndName;
import com.app.electronicserver.reports.RevenueByYear;
import com.app.electronicserver.reports.TopCategoriesByBrand;
import com.app.electronicserver.service.OrderService;
import com.app.electronicserver.service.ReportService;
import com.app.electronicserver.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reports")
public class ReportResource {
    private final ReportService reportService;

    @GetMapping("/top-brands")
    public ResponseEntity<List<QuantityAndName>> getTopBrands() {
        return ResponseEntity.ok().body(reportService.getReportBrandQuantityAndName());
    }

    @GetMapping("/orders/{year}")
    public ResponseEntity<List<OrderRevenueByMothnAndYear>> topCategoriesByBrand(@PathVariable("year") Integer year) {
        return ResponseEntity.ok().body(reportService.getOrderRevenueByMonthAndYear(year));
    }
    @GetMapping("/categories")
    public ResponseEntity<List<TopCategoriesByBrand>> getOrderRevenueByMonthAndYear(@RequestParam("bname") String bname) {
        return ResponseEntity.ok().body(reportService.topCategoriesByBrand(bname));
    }

    @GetMapping("/revenue/{year}")
    public ResponseEntity<List<RevenueByYear>> getRevenueByYear(@PathVariable("year") Integer year) {
        return ResponseEntity.ok().body(reportService.getRevenueByYear(year));
    }



}
