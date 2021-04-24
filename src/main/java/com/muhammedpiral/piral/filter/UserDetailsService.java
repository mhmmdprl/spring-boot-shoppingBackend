package com.muhammedpiral.piral.filter;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.muhammedpiral.piral.entity.account.Users;
import com.muhammedpiral.piral.repository.UserRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {



    @Autowired
    private UserRepository userRepository;
   
   

 


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    	Users user=this.userRepository.findByUsername(username);
        if (user!=null) {
            return new User(username,user.getPassword(), new ArrayList<>());
        }

        throw new UsernameNotFoundException(username);
    }
}