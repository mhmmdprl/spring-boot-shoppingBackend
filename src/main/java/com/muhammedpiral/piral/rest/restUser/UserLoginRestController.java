package com.muhammedpiral.piral.rest.restUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muhammedpiral.piral.filter.TokenManager;
import com.muhammedpiral.piral.request.LoginRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserLoginRestController {

	@Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;
	
	@PostMapping
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
		 try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	            return ResponseEntity.ok(tokenManager.generateToken(loginRequest.getUsername()));
	        } catch (Exception e) {
	            throw e;
	        }
		
	}
	
}
