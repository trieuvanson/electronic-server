package com.app.electronicserver.api;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.service.AddressService;
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
@RequestMapping("/api/address")
public class AddressResource {
    private final AddressService ADDRESS_SERVICE;

    @GetMapping("/")
    public ResponseEntity<List<Address>> getAddresses() {
        return ResponseEntity.ok().body(ADDRESS_SERVICE.getAddress());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ADDRESS_SERVICE.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/address/save").toUriString());
        return ResponseEntity.created(uri).body(ADDRESS_SERVICE.saveAddress(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable("id") Integer id, @RequestBody Address address) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/address/update/{id}").toUriString());
        return ResponseEntity.created(uri).body(ADDRESS_SERVICE.updateAddress(address, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable("id") Integer id) {
        ADDRESS_SERVICE.deleteAddress(id);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("DETELE", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
