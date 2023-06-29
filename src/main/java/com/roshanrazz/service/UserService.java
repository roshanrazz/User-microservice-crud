package com.roshanrazz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roshanrazz.entity.User;
import com.roshanrazz.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User getUser(String username) {
		
		return userRepository.findByUsername(username);
		
	}
	
	public List<User> getUsers() {
		
		return userRepository.findAll();
		
	}
	
	public User createUser(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	public User updateUser(String username,User user) {
		User user2 = userRepository.findByUsername(username);
		user2.setFirstName(user.getFirstName());
		user2.setLastName(user.getLastName());
		user2.setCity(user.getCity());
		user2.setAddress(user.getAddress());
		user2.setContactNumber(user.getContactNumber());
		user2.setCountry(user.getCountry());
		user2.setPassword(user.getPassword());
		return userRepository.saveAndFlush(user2);
	}
	
	public void deleteUser(String username) {
		try {
			User user = userRepository.findByUsername(username);
			userRepository.delete(user);
			//userRepository.deleteByUsername(username);
			System.out.println("USer delete successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

}
