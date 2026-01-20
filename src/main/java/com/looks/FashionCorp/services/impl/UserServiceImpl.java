package com.looks.FashionCorp.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.looks.FashionCorp.Dtos.UserDto;
import com.looks.FashionCorp.Repository.UserRepository;
import com.looks.FashionCorp.Services.UserService;
import com.looks.FashionCorp.entities.User;
import com.looks.FashionCorp.exceptions.PasswordMismatchException;
import com.looks.FashionCorp.exceptions.UserNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepositories;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public UserDto register(UserDto userDto) throws PasswordMismatchException {
		
		if(!userDto.getPassword().equals(userDto.getConfirmPassword())) {
			throw new PasswordMismatchException("Password and Confirm Pass does Not Match");
		}
		
		User user = modelMapper.map(userDto, User.class);
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		User savedUser = userRepositories.save(user);
		UserDto dto = modelMapper.map(savedUser, UserDto.class);
		dto.setPassword(null);
		return dto;
	}

	@Override
	public UserDto getUserById(String id) {
		User user = userRepositories.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
		UserDto dto = modelMapper.map(user, UserDto.class);
		dto.setPassword(null);
		return dto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> list = userRepositories.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return list;
		
	}

	@Override
	public UserDto updateUser(UserDto userDto, String id) {
		User user = userRepositories.findById(id).orElseThrow(() -> new UserNotFoundException("User Not Found"));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		
		if(userDto.getPassword() != null && !userDto.getPassword().isBlank()) {
			user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		}
		
		userRepositories.save(user);
		UserDto dto = modelMapper.map(user, UserDto.class);
		dto.setPassword(null);
		return dto;
	}

	@Override
	public void deleteUser(String id) {
		if(!userRepositories.existsById(id)) {
			throw new UserNotFoundException("User Not Found");
		}
		userRepositories.deleteById(id);		
	}

}
