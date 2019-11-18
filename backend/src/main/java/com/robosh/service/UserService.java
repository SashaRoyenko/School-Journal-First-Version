package com.robosh.service;

import com.robosh.data.dto.UserDto;
import com.robosh.data.entity.User;
import com.robosh.data.enumeration.Role;
import com.robosh.data.mapping.UserMapper;
import com.robosh.data.repository.UserRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;
    private UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
    }

    public UserDto save(UserDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userMapper.userToDto(userRepository.save(userMapper.dtoToUser(userDto)));
    }

    // todo delete in release
    public UserDto saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userMapper.userToDto(userRepository.save(user));
    }

    public ResponseEntity delete(Long id) {
        userRepository.delete(findById(id));
        return ResponseEntity.ok().build();
    }

    public UserDto update(UserDto userDto) {
        if(userDto.getPassword() != null){
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        User currentUser = findById(userDto.getId());
        User updateUser = userMapper.dtoToUser(userDto);
        modelMapper.map(updateUser, currentUser);
        return userMapper.userToDto(userRepository.save(currentUser));
    }

    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
