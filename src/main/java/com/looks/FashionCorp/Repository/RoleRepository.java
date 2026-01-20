package com.looks.FashionCorp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.Enums.AppRole;
import com.looks.FashionCorp.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByAppRole(AppRole appRole);

}
