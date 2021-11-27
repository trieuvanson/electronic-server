package com.app.electronicserver.service.impl;

import com.app.electronicserver.repo.OrderDetailRepo;
import com.app.electronicserver.repo.OrderRepo;
import com.app.electronicserver.repo.ProductCategoryRepo;
import com.app.electronicserver.reports.OrderRevenueByMothnAndYear;
import com.app.electronicserver.reports.QuantityAndName;
import com.app.electronicserver.reports.RevenueByYear;
import com.app.electronicserver.reports.TopCategoriesByBrand;
import com.app.electronicserver.service.ProductCategoryService;
import com.app.electronicserver.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReportServiceImpl  implements ReportService {
    private final OrderDetailRepo orderDetailRepo;
    private final OrderRepo orderRepo;
    private final ProductCategoryRepo productCategoryRepo;

    @Override
    public List<QuantityAndName> getReportBrandQuantityAndName() {
        return orderDetailRepo.getQuantityAndNameFormOrderDetail();
    }


    @Override
    public List<OrderRevenueByMothnAndYear> getOrderRevenueByMonthAndYear(Integer year) {
        return orderRepo.getOrderRevenueByMonthAndYear(year);
    }

    @Override
    public List<TopCategoriesByBrand> topCategoriesByBrand(String bname) {
        return productCategoryRepo.topCategoriesByBrand('%' + bname + '%');
    }

    @Override
    public List<RevenueByYear> getRevenueByYear(Integer year) {
        return orderRepo.getRevenueByYear(year);
    }
}
