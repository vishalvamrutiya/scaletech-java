package com.delivery.daily.service;

import java.util.List;
import java.util.Optional;

import com.delivery.daily.dto.UserDTO;

public interface UserService {
	List<UserDTO> getAllUsers();
	UserDTO saveUser(UserDTO userDTO);
	Optional<UserDTO> getUserById(Integer id);
	UserDTO updateUser(Integer id, UserDTO userDTO);
}
