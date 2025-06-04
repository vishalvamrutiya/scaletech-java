package com.delivery.daily.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.delivery.daily.dto.UserDTO;
import com.delivery.daily.entity.User;
import com.delivery.daily.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
	    this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }
    
    @Override
    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findById(id).map(this::convertToDTO);
    }
    
    @Override
    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDTO.name());
        user.setLatitude(userDTO.latitude());
        user.setLongitude(userDTO.longitude());
        user.setGoogleLink(userDTO.googleLink());
        User updatedUser = userRepository.save(user);
        return convertToDTO(updatedUser);
    }
    
    // Convert User Entity to UserDTO
    private UserDTO convertToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getLatitide(), user.getLongitude(), user.getGoogleLink());
    }
    
 // Convert UserDTO to User Entity
    private User convertToEntity(UserDTO userDTO) {
        User user = new User(userDTO.id(), userDTO.name(), userDTO.latitude(), userDTO.longitude(), userDTO.googleLink());
        return user;
    }

}
