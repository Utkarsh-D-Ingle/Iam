package com.example.IdentityAndAccessManagement.service;

import com.example.IdentityAndAccessManagement.repositories.UserRepository;
import com.example.IdentityAndAccessManagement.entities.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.IdentityAndAccessManagement.security.securityConfig;
import com.example.IdentityAndAccessManagement.DTO.UserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class userService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User registerNewUser(UserDTO request) {
        // 1. Check if username is taken
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // 2. Create entity and ENCODE the password
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        
        // This is the crucial part:
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        newUser.setPasswordhash(encodedPassword);

        // 3. Save to database
        return userRepository.save(newUser);
    }
}
