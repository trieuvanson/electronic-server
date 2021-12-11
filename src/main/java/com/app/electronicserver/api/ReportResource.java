package com.app.electronicserver.api;

import com.app.electronicserver.reports.*;
import com.app.electronicserver.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/top-customer")
    public ResponseEntity<List<TotalAndName>> getTopByUser() {
        return ResponseEntity.ok().body(reportService.getTopByUser());
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
