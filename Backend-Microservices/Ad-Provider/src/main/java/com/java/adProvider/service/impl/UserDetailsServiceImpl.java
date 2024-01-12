package com.java.adProvider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.adProvider.model.User;
import com.java.adProvider.repo.*;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
	private UserRepository userRepository;



	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}




		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user=userRepository.findByUsername(username);
			if(user==null) {
				System.out.println("User not found Exception");
				throw new  UsernameNotFoundException("Invalid Credentials");
			}
			return user;
		}

	}

