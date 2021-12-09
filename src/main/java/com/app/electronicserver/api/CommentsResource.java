package com.app.electronicserver.api;

import com.app.electronicserver.model.Comments;
import com.app.electronicserver.service.CommentsService;
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
@RequestMapping("/api/comments")
public class CommentsResource {
    private final CommentsService commentsService;


    @GetMapping("/all")
    public List<Comments> getAllComments() {
        return commentsService.getAllComments();
    }

    @GetMapping("")
    public ResponseEntity<List<Comments>> getCommentsByUsername(@RequestParam("username") String username) {
        return ResponseEntity.ok().body(commentsService.getCommentsByUserUsername(username));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<List<Comments>> getCommentsByProductId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(commentsService.getCommentsByProductId(id));
    }
    @GetMapping("/get-by")
    public ResponseEntity<List<Comments>> getCommentsByUserUsernameAndProductId(@RequestParam ("username") String username,
                                                                                @RequestParam("productId") Integer productId) {
        return ResponseEntity.ok().body(commentsService.getCommentsByUserUsernameAndProductId(username, productId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comments> getCommentsByCommentsId(@PathVariable Integer id) {
        return ResponseEntity.ok().body(commentsService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Comments> saveComments(@RequestBody Comments Comments) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/Comments/save").toUriString());
        return ResponseEntity.created(uri).body(commentsService.saveComments(Comments));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comments> updateComments(@PathVariable("id") Integer id, @RequestBody Comments Comments) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/Comments/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(commentsService.updateComments(Comments, id));
    }

    @DeleteMapping("/{id}&{username}")
    public ResponseEntity<Map<String, Boolean>> deleteComments(@PathVariable("id") Integer id, @PathVariable("username") String username) {
        commentsService.removeCommentsByIdAndUserUsername(id, username);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DETELE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
