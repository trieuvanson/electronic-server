package com.app.electronicserver.api;

import com.app.electronicserver.model.CartItem;
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
public class FavoriteResource {
    private final FavoriteService FAVORITE_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<Favorite>> getCartItemsByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok().body(FAVORITE_SERVICE.getFavoritesByUsername(username));
    }

    @PostMapping("/")
    public ResponseEntity<Favorite> saveCartItem(@RequestBody Favorite favorite) {
        return ResponseEntity.ok().body(FAVORITE_SERVICE.saveFavorite(favorite));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favorite> updateCartItem(@RequestBody Favorite favorite, @PathVariable Integer id) {
        return ResponseEntity.ok().body(FAVORITE_SERVICE.updateFavorite(favorite, id));
    }

    @DeleteMapping("/{id}&{username}")
    public ResponseEntity<Map<String, Boolean>> deleteCartItem(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        FAVORITE_SERVICE.removeFavoriteByUsername(id, username);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
