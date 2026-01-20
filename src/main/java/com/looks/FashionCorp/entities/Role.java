package com.looks.FashionCorp.entities;

import java.util.HashSet;
import java.util.Set;

import com.looks.FashionCorp.Enums.AppRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
		
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private AppRole appRole;
	
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<User>();

}
