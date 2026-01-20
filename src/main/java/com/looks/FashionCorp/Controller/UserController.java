package com.looks.FashionCorp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.looks.FashionCorp.Dtos.UserDto;
import com.looks.FashionCorp.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> register(@RequestBody UserDto userDto){
		UserDto user = userService.register(userDto);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}

}
