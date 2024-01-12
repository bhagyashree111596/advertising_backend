package com.java.adProvider.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.adProvider.model.Role;
import com.java.adProvider.model.User;
import com.java.adProvider.model.UserRole;
import com.java.adProvider.repo.UserRepository;
import com.java.adProvider.response.PostUserResponse;
import com.java.adProvider.response.ResponseHandler;
import com.java.adProvider.response.UserResponse;
import com.java.adProvider.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/{username}")
	public ResponseEntity<?> getUser(@PathVariable("username") String username) throws Exception {
		User user = userService.getUser(username);

	//	int code = 401;
		if (user == null) {
			return ResponseHandler.responseBuilder("User Not Found", HttpStatus.NO_CONTENT.value(), null,
					HttpStatus.NO_CONTENT);
		}

		return ResponseHandler.responseBuilder("User Found", HttpStatus.OK.value(), null,
				HttpStatus.OK);
		//
		//		return ResponseEntity.ok().body("User Found"
	}

	@PostMapping("/")
	public ResponseEntity<?> AddUser(@RequestBody User user) throws Exception {
		
		// function to validateUser()
		if(user.getEmail()==null||user.getEmail()==""||user.getEmail().isEmpty())
		{
			return ResponseHandler.responseBuilder("Email Must Be Required", HttpStatus.NOT_ACCEPTABLE.value(), null,
					HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(user.getUsername().isEmpty()||user.getUsername()==""||user.getUsername()==null){
			return ResponseHandler.responseBuilder("Username Must Be Required", HttpStatus.NOT_ACCEPTABLE.value(), null,
					HttpStatus.NOT_ACCEPTABLE);
		}
		
		if(user.getPassword()==null||user.getPassword()==""||user.getPassword().isEmpty()){
			return ResponseHandler.responseBuilder("Password Must Be Required", HttpStatus.NOT_ACCEPTABLE.value(), null,
					HttpStatus.NOT_ACCEPTABLE);
		}
		
		// use isExist function to check record already exist or not
		User localUser = userRepository.findByUsername(user.getUsername());
		if (localUser != null) {
			return ResponseHandler.responseBuilder("User Already Exist", HttpStatus.CONFLICT.value(), null,
					HttpStatus.CONFLICT);
		} 
		
		UserRole userrole = new UserRole();
		Role roles = new Role();
		
		String user_id=UUID.randomUUID().toString();
		user.setUser_id(user_id);
		

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		user.setCreated_by(user.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setCreated_date(formatter.format(date));
				
		// roles object should be a part of user object 		
		Set<UserRole> userRole = new HashSet<>();
		roles.setDescription(user.getRole());
		// role details
		if (user.getRole().equals("AdProvider")) {
			roles.setRoleId(44L);
		}
		if (user.getRole().equals("AdViewer")) {
			roles.setRoleId(45L);
		}
		roles.setCreated_by(user.getEmail());
		roles.setCreated_date(formatter.format(date));

				// userRole details
		userrole.setRole(roles);
		userrole.setUser(user);
		userrole.setCreated_by(user.getEmail());
		userrole.setCreated_date(formatter.format(date));
		userRole.add(userrole);
		User createdUser = userService.createUser(user, userRole);

		return ResponseHandler.responseBuilder("You Are Registered Successfully", HttpStatus.OK.value(),
						createdUser, HttpStatus.OK);

	}

	@GetMapping("/")
	public ResponseEntity<?> getUsers() {
		List<User> userList = userService.getUser();
		if (userList == null) {
			return null;//(ResponseEntity<>)ResponseHandler.responseBuilder("User Not Fond", HttpStatus.NO_CONTENT);
		}
		return ResponseHandler.responseBuilder(" Successfully Fetched List Of Users", HttpStatus.OK.value(), userList,
				HttpStatus.OK);

	}
}
