package com.java.adProvider.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.adProvider.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

   public User findByUsername(String username);
   public User findByEmail(String email);
}
