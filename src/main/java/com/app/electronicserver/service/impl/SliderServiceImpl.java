package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Slide;
import com.app.electronicserver.repo.SlideRepo;
import com.app.electronicserver.service.SlideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Service @RequiredArgsConstructor
@Transactional
@Slf4j
public class SliderServiceImpl implements SlideService {

   private final SlideRepo slideRepo;

    @Override
    public List<Slide> getSlide() {
        return slideRepo.findAll();
    }

    @Override
    public Slide findById(Integer id) {
        return slideRepo.findById(id).get();
    }

    @Override
    public Slide saveSlide(Slide slide) {
        slide.setCreated_at(new Date());
        slide.setUpdate_at(new Date());
        return slideRepo.save(slide);
    }

    @Override
    public Slide updateSlide(Slide slide, Integer id) {
        slide.setId(id);
        slide.setUpdate_at(new Date());
        return slideRepo.save(slide);
    }

    @Override
    public void deleteSlide(Integer id) {
        Slide slide = findById(id);
        slideRepo.delete(slide);
    }
}
