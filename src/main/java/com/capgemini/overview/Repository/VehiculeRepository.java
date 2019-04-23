package com.capgemini.overview.Repository;

import com.capgemini.overview.Entity.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RepositoryRestResource(path = "vehicles", collectionResourceRel = "vehicles", itemResourceRel = "vehicle")
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    @GetMapping("/{name}")
    Optional<Vehicule> findByName(@PathVariable String name);

}
