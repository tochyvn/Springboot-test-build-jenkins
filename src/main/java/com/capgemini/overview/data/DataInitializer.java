package com.capgemini.overview.data;

import com.capgemini.overview.Entity.RandomCity;
import com.capgemini.overview.Entity.security.Role;
import com.capgemini.overview.Entity.security.RoleName;
import com.capgemini.overview.Repository.RandomCityRepository;
import com.capgemini.overview.Repository.RoleRepository;
import com.capgemini.overview.Repository.UserRepository;
import com.capgemini.overview.Entity.security.User;
import com.capgemini.overview.Entity.Vehicule;
import com.capgemini.overview.Repository.VehiculeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    VehiculeRepository vehiculeRepository;

    @Autowired
    UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RandomCityRepository randomCityRepository;

    @Override
    public void run(String... args) throws Exception {
        log.debug("Initializing vehicules data...");
        Arrays.asList("Car", "Moto", "Bus")
                .forEach(name -> vehiculeRepository.saveAndFlush(Vehicule.builder().name(name).build()) );

        Arrays.asList(RoleName.STANDARD_USER, RoleName.ADMIN_USER, RoleName.SUPER_ADMIN_USER)
                .forEach(roleName -> roleRepository.saveAndFlush(Role.builder().roleName(roleName).build()));

        log.debug("Printing all vehicules...");
        vehiculeRepository.findAll().forEach(v -> log.debug("Vehicule : " + toString()));

        this.users.save(User.builder()
                .username("user")
                .password(this.passwordEncoder.encode("password"))
                .roles(Arrays.asList(Role.builder().id(new Long(1)).build()))
                .firstName("YVANOV")
                .lastName("TOCHAP")
                .build()
        );
        this.users.save(User.builder()
                .username("admin")
                .password(this.passwordEncoder.encode("admin"))
                .roles(Arrays.asList(Role.builder().id(new Long(1)).build(), Role.builder().id(new Long(2)).build()))
                .firstName("Test")
                .lastName("test")
                .build()
        );

        Arrays.asList("Lyon", "Nonkon", "Houston", "Toronto", "Yaoundé", "Douala")
                .forEach(city -> this.randomCityRepository.save(RandomCity.builder().name(city).build()));

    }
}
