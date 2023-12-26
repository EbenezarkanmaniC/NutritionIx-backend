package com.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.authservice.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, String>{

	public User findByPhoneNumberAndPassword(String phoneNumber, String password);
	

}
