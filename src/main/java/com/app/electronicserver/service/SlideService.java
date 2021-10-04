package com.app.electronicserver.service;

import com.app.electronicserver.model.Slide;
import com.app.electronicserver.repo.SlideRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SlideService{
    List<Slide> getSlide();

    Slide findById(Integer id);

    Slide saveSlide(Slide slide);

    Slide updateSlide(Slide slide, Integer id);

    void deleteSlide(Integer id);
}
