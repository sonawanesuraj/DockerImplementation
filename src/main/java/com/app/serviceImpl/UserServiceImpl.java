package com.app.serviceImpl;

import com.app.dto.UserDto;
import com.app.entities.UserEntity;
import com.app.repository.UserRepository;
import com.app.serviceInterface.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserServiceInterface{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(userDto.getEmail());
		userEntity.setEmail(userDto.getEmail());
		userEntity.setAddress(userDto.getAddress());
		this.userRepository.save(userEntity);
		return userDto;
	}

}
