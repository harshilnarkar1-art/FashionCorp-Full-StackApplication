package com.looks.FashionCorp.Services;

import java.util.List;

import com.looks.FashionCorp.Dtos.UserDto;
import com.looks.FashionCorp.exceptions.PasswordMismatchException;

public interface UserService {
	
	UserDto register(UserDto userDto) throws PasswordMismatchException;
	
	UserDto getUserById(String id);
	
	List<UserDto> getAllUsers();
	
	UserDto updateUser(UserDto userDto, String id);
	
	void deleteUser(String id);

}
