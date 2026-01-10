package com.looks.FashionCorp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.looks.FashionCorp.dtos.UserDto;
import com.looks.FashionCorp.entites.User;
import com.looks.FashionCorp.repositories.UserRepository;
import com.looks.FashionCorp.services.UserService;

@RestController
@RequestMapping("users")
public class UserController {

    private UserRepository userRepository;
	
	@Autowired
	private UserService userService;

//    UserController(repositories.UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto user = userService.createUser(userDto);
		return new ResponseEntity<UserDto>(user,HttpStatus.CREATED);
	}

	@GetMapping("/{user_id}")
	public ResponseEntity<UserDto> getUser(@PathVariable int user_id){
		
		return ResponseEntity.ok(userService.getUser(user_id));
	}
	
	@PutMapping("/{user_id}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable int user_id){
		
		return ResponseEntity.ok(userService.updateUser(userDto, user_id));
	}
	
	@DeleteMapping("/{user_id}")
	public ResponseEntity<UserDto> deleteUser(@PathVariable int user_id){
		userService.deleteUser(user_id);
	return ResponseEntity.noContent().build();
		
	}
	
	@GetMapping("/{email}/check")
	public boolean checkEmail(@PathVariable String email) {
		return userRepository.existsByEmail(email);
	}
	

}
