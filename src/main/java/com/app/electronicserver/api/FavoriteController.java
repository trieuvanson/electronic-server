package com.app.electronicserver.api;

import com.app.electronicserver.model.Favorite;
import com.app.electronicserver.service.FavoriteService;
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
@RequestMapping("/api/favorite")
public class FavoriteController {
    private final FavoriteService FAVORITE_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<Favorite>> getFavorites() {
        return ResponseEntity.ok().body(FAVORITE_SERVICE.getFavorite());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> getFavorite(@PathVariable Integer id) {
        return ResponseEntity.ok().body(FAVORITE_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Favorite> saveFavorite(@RequestBody Favorite favorite) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/favorite/save").toUriString());
        return ResponseEntity.created(uri).body(FAVORITE_SERVICE.saveFavorite(favorite));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorite> updateFavorite(@PathVariable("id") Integer id, @RequestBody Favorite favorite) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/favorite/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(FAVORITE_SERVICE.updateFavorite(favorite, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        FAVORITE_SERVICE.deleteFavorite(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DETELE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
