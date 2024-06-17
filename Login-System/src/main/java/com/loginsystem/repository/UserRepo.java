package com.loginsystem.repository;

import com.loginsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	public User findUserByEmail(String email);

}
