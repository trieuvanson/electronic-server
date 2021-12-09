package com.app.electronicserver.api;

import com.app.electronicserver.model.Rating;
import com.app.electronicserver.service.RatingService;
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
@RequestMapping("/api/rating")
public class RatingResource {
    private final RatingService ratingService;
    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.ok().body(ratingService.getAllRating());
    }
    @GetMapping("")
    public ResponseEntity<List<Rating>> getRatingByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok().body(ratingService.getRatingByUserUsername(username));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Rating>> getRatingByProductId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ratingService.getRatingByProductId(id));
    }
    @GetMapping("/get-by")
    public ResponseEntity<List<Rating>> getRatingByUserUsernameAndProductId(@RequestParam ("username") String username,
                                                                                @RequestParam("productId") Integer productId) {
        return ResponseEntity.ok().body(ratingService.getRatingByUserUsernameAndProductId(username, productId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingByRatingId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ratingService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/Rating/save").toUriString());
        return ResponseEntity.created(uri).body(ratingService.saveRating(rating));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable("id") Integer id, @RequestBody Rating Rating) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/Rating/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(ratingService.updateRating(Rating, id));
    }

    @DeleteMapping("/{id}&{username}")
    public ResponseEntity<Map<String, Boolean>> deleteRating(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        ratingService.removeRatingByIdAndUserUsername(id, username);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DETELE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
