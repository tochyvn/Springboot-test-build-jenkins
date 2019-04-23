package com.capgemini.overview.Repository;

import com.capgemini.overview.Entity.RandomCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomCityRepository extends JpaRepository<RandomCity, Long> {
}
