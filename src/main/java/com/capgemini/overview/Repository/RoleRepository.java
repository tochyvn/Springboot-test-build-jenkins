package com.capgemini.overview.Repository;

import com.capgemini.overview.Entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
