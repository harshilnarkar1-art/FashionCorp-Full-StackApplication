package com.looks.FashionCorp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.looks.FashionCorp.dtos.UserDto;
import com.looks.FashionCorp.entites.User;
import com.looks.FashionCorp.repositories.UserRepository;
import com.looks.FashionCorp.services.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}
	
	@Override
	public UserDto getUser(int user_id) {
		User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("Id Not Found"));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int user_id) {
		User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("Id Not Found"));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public void deleteUser(int user_id) {
		User user = userRepository.findById(user_id).orElseThrow(() -> new RuntimeException("Id Not Found"));
		userRepository.delete(user);
		
	}

}
