package com.looks.FashionCorp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String confirmPassword;

}
