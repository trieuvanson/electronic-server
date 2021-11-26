package com.app.electronicserver.service;


import com.app.electronicserver.reports.QuantityAndName;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {
    List<QuantityAndName> getReportBrandQuantityAndName();
}
