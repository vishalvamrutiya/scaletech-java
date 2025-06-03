package com.delivery.daily.service;

import java.util.List;

import com.delivery.daily.dto.UserDTO;

public interface UserService {
	List<UserDTO> getAllUsers();
	UserDTO saveUser(UserDTO userDTO);
}
