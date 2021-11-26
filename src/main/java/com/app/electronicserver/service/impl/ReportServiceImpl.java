package com.app.electronicserver.service.impl;

import com.app.electronicserver.repo.OrderDetailRepo;
import com.app.electronicserver.reports.QuantityAndName;
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

    @Override
    public List<QuantityAndName> getReportBrandQuantityAndName() {
        return orderDetailRepo.getQuantityAndNameFormOrderDetail();
    }
}
