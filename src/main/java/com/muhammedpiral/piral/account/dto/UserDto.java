package com.muhammedpiral.piral.account.dto;

import java.util.Date;
import java.util.UUID;

import com.muhammedpiral.piral.entity.account.Users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class UserDto {
   
	private String username;
	
	private UUID uuid;
	
	private String firstName;
	
	private String lastName;

	private Date birtOfDate;
	
  public static UserDto userToUserDto(Users users) {
	  
	UserDto userDto=new UserDto();
	userDto.setUuid(users.getUuid());
	userDto.setFirstName(users.getFirstName());
	userDto.setLastName(users.getLastName());
	userDto.setBirtOfDate(users.getBirtOfDate());
	userDto.setUsername(users.getUsername());
	
	return userDto;
  }
}
