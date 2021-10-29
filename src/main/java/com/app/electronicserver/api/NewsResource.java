package com.app.electronicserver.api;

import com.app.electronicserver.model.News;
import com.app.electronicserver.service.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/new")
public class NewsResource {
    private final NewService NEW_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<News>> getNews() {
        return ResponseEntity.ok().body(NEW_SERVICE.getNew());
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNew(@PathVariable Integer id) {
        return ResponseEntity.ok().body(NEW_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<News> saveNew(@RequestBody News news) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/new/save").toUriString());
        return ResponseEntity.created(uri).body(NEW_SERVICE.saveNew(news));
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNew(@PathVariable("id") Integer id, @RequestBody News news) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/new/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(NEW_SERVICE.updateNew(news, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        NEW_SERVICE.deleteNew(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
