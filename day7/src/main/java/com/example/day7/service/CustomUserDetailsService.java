package com.example.day7.service;

import com.example.day7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.day7.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
		
		User user=repository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("user not found "));
		
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.authorities("User")
				.build();
		
		
		
	}
	
	
	
	
	

}
