package com.roshanrazz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roshanrazz.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	

	User findByUsername(String username);

	void deleteByUsername(String username);

}
