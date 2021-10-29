package com.app.electronicserver.service;

import com.app.electronicserver.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewService {
    List<News> getNew();

    News saveNew(News news);

    News updateNew(News news, Integer id);

    void deleteNew(Integer id);

    News findById(Integer id);
}
