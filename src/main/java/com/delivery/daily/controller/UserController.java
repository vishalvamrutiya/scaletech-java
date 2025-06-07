package com.delivery.daily.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.daily.dto.UserDTO;
import com.delivery.daily.entity.User;
import com.delivery.daily.repository.UserRepository;
import com.delivery.daily.service.UserService;

@RestController
@RequestMapping("/api") // Base URL for all endpoints in this controller
public class UserController {

	
	private final UserService userService;

	public UserController(UserService userService) {
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
	
	@CrossOrigin
	@GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id) {
        Optional<UserDTO> user = this.userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@CrossOrigin
	@PutMapping("/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        try {
            UserDTO updatedUser = this.userService.updateUser(id, userDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
