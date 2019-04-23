package com.capgemini.overview.service;

import com.capgemini.overview.Entity.RandomCity;
import com.capgemini.overview.Entity.security.User;

import java.util.List;

public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
