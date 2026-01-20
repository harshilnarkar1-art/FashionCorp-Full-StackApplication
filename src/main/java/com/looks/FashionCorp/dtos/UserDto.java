package com.looks.FashionCorp.Dtos;

import java.util.HashSet;
import java.util.Set;

import com.looks.FashionCorp.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String id;

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password must be 6-20 characters")
    private String password;

    @NotEmpty(message = "Confirm password is required")
    private String confirmPassword;
	
	private Set<Role> roles = new HashSet<Role>();

}
