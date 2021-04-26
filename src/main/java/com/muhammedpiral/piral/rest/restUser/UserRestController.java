package com.muhammedpiral.piral.rest.restUser;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.account.dto.UserDto;
import com.muhammedpiral.piral.service.UserService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserRestController {

	private final UserService userService;
	
	@GetMapping
	List<UserDto> findAll(){
		
		return this.userService.findAll();
		
	}
	@PostMapping
	ResponseEntity<String> saveUser(@RequestBody UserDto userDto){
		
		
		this.userService.userSave(userDto);
		
		return ResponseEntity.ok("Eklendi!");
	}
	
	@DeleteMapping("/{uuid}") 
	void deleteUser(@PathVariable UUID uuid){
		Long updatedById=3L;
		this.userService.deleteUser(updatedById,uuid);
	}
	
	
}
