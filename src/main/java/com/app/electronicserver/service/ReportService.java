package com.app.electronicserver.service;


import com.app.electronicserver.reports.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    List<QuantityAndName> getReportBrandQuantityAndName();
    List<OrderRevenueByMothnAndYear> getOrderRevenueByMonthAndYear(Integer year);
    List<TopCategoriesByBrand> topCategoriesByBrand(String bname);
    List<RevenueByYear> getRevenueByYear(Integer year);
    List<TotalAndName> getTopByUser();


}
