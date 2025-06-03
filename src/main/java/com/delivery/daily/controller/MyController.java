package com.delivery.daily.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.daily.dto.UserDTO;
import com.delivery.daily.entity.User;
import com.delivery.daily.repository.UserRepository;
import com.delivery.daily.service.UserService;

@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class MyController {

	
	private final UserService userService;

	public MyController(UserService userService) {
		this.userService = userService;
	}
    
	@GetMapping("/status") // Endpoint for GET requests to /api/hello
    public String sayHello() {
        return "Service is up and running";
    }
    
	@CrossOrigin
    @GetMapping("/users")
    public List<UserDTO> findAllCustomers() {
      return this.userService.getAllUsers();
    }
	
	@CrossOrigin
	@PostMapping("/users")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		System.out.println("Test " + user.name());
		return ResponseEntity.ok(this.userService.saveUser(user));
	}
}
