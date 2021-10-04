package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.New;
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
    public List<New> getNew() {
        return newRepo.findAll();
    }

    @Override
    public New saveNew(New news) {
        news.setCreated_at(new Date());
        news.setUpdate_at(new Date());
        return newRepo.save(news);
    }

    @Override
    public New updateNew(New news, Integer id) {
        news.setId(id);
        news.setUpdate_at(new Date());
        return newRepo.save(news);
    }

    @Override
    public void deleteNew(Integer id) {
        New news = findById(id);
        newRepo.delete(news);
    }

    @Override
    public New findById(Integer id) {
        return newRepo.findById(id).get();
    }
}
