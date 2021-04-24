package com.muhammedpiral.piral.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Users;
import com.muhammedpiral.piral.entity.account.dto.UserDto;
import com.muhammedpiral.piral.repository.UserRepository;
import com.muhammedpiral.piral.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository;
	@Override
	public void userSave(UserDto userDto) {
		Users user=new Users();
		user.setUsername(userDto.getUsername());
		user.setBirtOfDate(userDto.getBirtOfDate());
		user.setLastName(userDto.getLastName());
		user.setFirstName(userDto.getFirstName());
		
		this.userRepository.save(user);
		
		
	}

	@Override
	public Users findByUsername(String username) {

		return this.userRepository.findByUsername(username);
	}

	@Override
	public UserDto findById(Long id) {
		Optional<Users> user=this.userRepository.findById(id);

		return UserDto.userToUserDto(user.get());
	}

	@Override
	public void deleteUser(Long updatedById,UUID uuid) {
		this.userRepository.delete(updatedById,uuid);
		
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDto> findAll() {

		return  this.userRepository.findAll().stream().map(UserDto::userToUserDto).collect(Collectors.toList());
	}

	@Override
	public Users findByUuid(UUID uuid) {
		
		return this.findByUuid(uuid);
	}

}
