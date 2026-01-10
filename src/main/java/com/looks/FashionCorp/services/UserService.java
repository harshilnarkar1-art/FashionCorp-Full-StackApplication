package com.looks.FashionCorp.services;

import com.looks.FashionCorp.dtos.UserDto;
import com.looks.FashionCorp.entites.User;

public interface UserService {
	
	// Create 
	UserDto createUser(UserDto userDto);
	
	// Read
	UserDto getUser(int user_id);
	
	// Update
	UserDto updateUser(UserDto userDto, int user_id);
	
	// Delete
	void deleteUser(int user_id);

}
