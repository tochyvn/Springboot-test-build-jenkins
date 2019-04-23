package com.capgemini.overview.web;

import com.capgemini.overview.Entity.Vehicule;
import com.capgemini.overview.exception.VehiculeNotFoundException;
import com.capgemini.overview.Repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("v1/vehicles")
public class VehiculeController {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    @GetMapping("")
    public ResponseEntity all() {
        return ResponseEntity.ok(vehiculeRepository.findAll());
    }

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody Vehicule vehicule) {
        Vehicule added = vehiculeRepository.save(vehicule);

        if (added == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(added.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(vehiculeRepository.findById(id)
                .orElseThrow(() -> new VehiculeNotFoundException())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Vehicule existed = vehiculeRepository.findById(id).
                orElseThrow(() -> new VehiculeNotFoundException());
        vehiculeRepository.delete(existed);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable("id") Long id,
            @RequestBody Vehicule vehicule) {

        Vehicule toUpdate = vehiculeRepository.findById(id)
                .orElseThrow(()-> new VehiculeNotFoundException());
        toUpdate.setName(vehicule.getName());

        return ResponseEntity.noContent().build();
    }
}
