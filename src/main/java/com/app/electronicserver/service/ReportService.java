package com.app.electronicserver.service;


import com.app.electronicserver.reports.OrderRevenueByMothnAndYear;
import com.app.electronicserver.reports.QuantityAndName;
import com.app.electronicserver.reports.TopCategoriesByBrand;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    List<QuantityAndName> getReportBrandQuantityAndName();
    List<OrderRevenueByMothnAndYear> getOrderRevenueByMonthAndYear(Integer year);
    List<TopCategoriesByBrand> topCategoriesByBrand(String bname);

}
