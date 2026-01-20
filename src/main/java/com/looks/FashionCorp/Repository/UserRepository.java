package com.looks.FashionCorp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.looks.FashionCorp.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}
