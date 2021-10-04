package com.app.electronicserver.service;

import com.app.electronicserver.model.New;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewService {
    List<New> getNew();

    New saveNew(New news);

    New updateNew(New news, Integer id);

    void deleteNew(Integer id);

    New findById(Integer id);
}
