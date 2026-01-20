package com.looks.FashionCorp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.looks.FashionCorp.Enums.AppRole;
import com.looks.FashionCorp.Repository.RoleRepository;
import com.looks.FashionCorp.entities.Role;

@Configuration
public class DataLoader {
	
	@Bean
	CommandLineRunner loadRoles(RoleRepository roleRepository) {
		return args -> {
			if(roleRepository.findByAppRole(AppRole.ROLE_USER).isEmpty()) {
				Role role = new Role();
				role.setAppRole(AppRole.ROLE_USER);
				roleRepository.save(role);
			}
			
			if(roleRepository.findByAppRole(AppRole.ROLE_ADMIN).isEmpty()) {
				Role role = new Role();
				role.setAppRole(AppRole.ROLE_ADMIN);
				roleRepository.save(role);
			}
		};

	}

}
