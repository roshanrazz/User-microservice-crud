package com.roshanrazz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.roshanrazz.entity.User;
import com.roshanrazz.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getUser(username);
	}
	
	@GetMapping("")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("")
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/{username}")
	public User updateUser(@PathVariable String username,@RequestBody User user) {
		return userService.updateUser(username,user);
	}
	
	@DeleteMapping("/{username}")
	public String deleteUser(@PathVariable String username) {
		try{
			userService.deleteUser(username);
			return "User deleted Successfully";
		}catch(Exception e){
			e.printStackTrace();
			return "Error occured";
			
		}
		
		
	}

}
