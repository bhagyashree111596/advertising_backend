package com.java.adProvider.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.adProvider.exceptions.UserFoundException;
import com.java.adProvider.exceptions.UserNotFoundException;
import com.java.adProvider.model.User;
import com.java.adProvider.model.UserRole;
import com.java.adProvider.repo.RoleRepository;
import com.java.adProvider.repo.UserRepository;
import com.java.adProvider.response.PostUserResponse;
import com.java.adProvider.response.UserResponse;
import com.java.adProvider.service.UserService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;


	@Autowired
	private RoleRepository roleRepository;



	@Override
	public void deleteUser(Long userid) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userid);
	}

	@Override
	public User getUser(String username) throws Exception{
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username);
//		HttpStatusCode status;
		UserResponse userResponse=new UserResponse();
		if(user==null)
		{
			//status=HttpStatusCode.valueOf(401);
			throw new UserNotFoundException();

		// return  ResponseHandler.responseBuilder("User Not Found", HttpStatus.NO_CONTENT.value(),HttpStatus.NO_CONTENT);
		}
		return user;
	}
//
//	@Override
//     public User updateUser(User user) {																																// TODO Auto-generated method stub
//		return userRepository.save(user);
//	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		for (UserRole ur : userRoles) {
			roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		return userRepository.save(user);
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		List<User> user=null;
		user=userRepository.findAll();

		return user ;
	}




}
