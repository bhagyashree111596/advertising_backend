package com.java.adProvider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.adProvider.config.JwtUtil;
import com.java.adProvider.exceptions.UserNotFoundException;
import com.java.adProvider.model.LoginUserRequest;
import com.java.adProvider.model.LoginUserResponse;
import com.java.adProvider.service.impl.UserDetailsServiceImpl;

@RestController
@RequestMapping
public class AuthenticateController {

	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	private ResponseEntity<?> generatedToken(@RequestBody LoginUserRequest loginRequest) throws Exception{

		try {
			  authenticate(loginRequest.getUsername(),loginRequest.getPassword());


		}catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");

		}
		UserDetails userDetails=this.userDetailsServiceImpl.loadUserByUsername(loginRequest.getUsername());
		  String token=this.jwtUtil.generateToken(userDetails);
		  System.out.println("Token"+token);
		return ResponseEntity.ok(new LoginUserResponse(token));

	}


	private void authenticate(String username,String password) throws Exception
	{
		try {
	    	  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

		}catch(DisabledException e) {
	    	  throw new Exception("user Disabled"+e.getMessage());
	      }catch(BadCredentialsException e) {
	    	  throw new Exception("invaild Credentials ......"+e.getMessage());
	      }
	}
}

