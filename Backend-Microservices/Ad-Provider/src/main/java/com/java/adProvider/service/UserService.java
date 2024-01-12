package com.java.adProvider.service;

import java.util.List;
import java.util.Set;

import com.java.adProvider.model.User;
import com.java.adProvider.model.UserRole;
import com.java.adProvider.response.PostUserResponse;

public interface UserService {


   public void deleteUser(Long userid);

   //get User by user id
   public User getUser(String username) throws Exception;
   public List<User> getUser();

//   public User updateUser(User user);

   User createUser(User user, Set<UserRole> userRole) throws Exception;


}
