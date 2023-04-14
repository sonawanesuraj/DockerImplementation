package com.app.controller;

import com.app.dto.ErrorResponceDto;
import com.app.dto.SuccessResponceDto;
import com.app.dto.UserDto;
import com.app.serviceInterface.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@PostMapping()
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
		try {
			userDto = this.userServiceInterface.addUser(userDto);
	
		return new ResponseEntity<>(new SuccessResponceDto("user addded successfully","User Added"),HttpStatus.OK);

		

	}catch(Exception e) {
		return new ResponseEntity<>(new ErrorResponceDto("User not found","not found"),HttpStatus.BAD_REQUEST);

	}
	}
}
	
	


