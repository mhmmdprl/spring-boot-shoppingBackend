package com.muhammedpiral.piral.service;

import java.util.List;
import java.util.UUID;

import com.muhammedpiral.piral.entity.account.Users;
import com.muhammedpiral.piral.entity.account.dto.UserDto;

public interface UserService {
	
	void userSave(UserDto userDto);
	
	Users findByUsername(String username);
	
	UserDto findById(Long id);
	
	void deleteUser(Long updatedBy,UUID uuid);
	
	UserDto updateUser(UserDto userDto);

	List<UserDto> findAll();
	
	Users findByUuid(UUID uuid);
	

}
