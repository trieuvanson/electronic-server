package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.News;
import com.app.electronicserver.repo.NewRepo;
import com.app.electronicserver.service.NewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NewServiceImpl implements NewService {
    private final NewRepo newRepo;

    @Override
    public List<News> getNew() {
        return newRepo.findAll();
    }

    @Override
    public News saveNew(News news) {
        news.setCreated_at(new Date());
        news.setUpdate_at(new Date());
        return newRepo.save(news);
    }

    @Override
    public News updateNew(News news, Integer id) {
        news.setId(id);
        news.setUpdate_at(new Date());
        return newRepo.save(news);
    }

    @Override
    public void deleteNew(Integer id) {
        News news = findById(id);
        newRepo.delete(news);
    }

    @Override
    public News findById(Integer id) {
        return newRepo.findById(id).get();
    }
}
