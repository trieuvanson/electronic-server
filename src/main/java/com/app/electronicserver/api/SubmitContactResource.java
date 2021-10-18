package com.app.electronicserver.api;

import com.app.electronicserver.model.SubmitContact;
import com.app.electronicserver.service.SubmitContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/submit-contact")
public class SubmitContactResource {
    private final SubmitContactService SUBMIT_CONTACT_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<SubmitContact>> getSubmitContacts() {
        return ResponseEntity.ok().body(SUBMIT_CONTACT_SERVICE.getSubmitContact());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubmitContact> getSubmitContact(@PathVariable Long id) {
        return ResponseEntity.ok().body(SUBMIT_CONTACT_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<SubmitContact> postSubmitContact(@RequestBody SubmitContact submitContact) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/submit-contact/save").toUriString());
        return ResponseEntity.created(uri).body(SUBMIT_CONTACT_SERVICE.saveSubmitContact(submitContact));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubmitContact> putSubmitContact(@PathVariable Long id,@RequestBody SubmitContact submitContact) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/submit-contact/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(SUBMIT_CONTACT_SERVICE.updateSubmitContact(submitContact, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Long id) {
        SUBMIT_CONTACT_SERVICE.deleteSubmitContact(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DELETE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
