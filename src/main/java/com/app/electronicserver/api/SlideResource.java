package com.app.electronicserver.api;

import com.app.electronicserver.model.Slide;
import com.app.electronicserver.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/slide")
public class SlideResource {
    private final SlideService SLIDER_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<Slide>> getSlides() {
        return ResponseEntity.ok().body(SLIDER_SERVICE.getSlide());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Slide> getSlide(@PathVariable Integer id) {
        return ResponseEntity.ok().body(SLIDER_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Slide> saveSlide(@RequestBody Slide Slide) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/slide/save").toUriString());
        return ResponseEntity.created(uri).body(SLIDER_SERVICE.saveSlide(Slide));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slide> updateSlide(@PathVariable("id") Integer id, @RequestBody Slide slide) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/slide/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(SLIDER_SERVICE.updateSlide(slide, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        SLIDER_SERVICE.deleteSlide(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }

}
