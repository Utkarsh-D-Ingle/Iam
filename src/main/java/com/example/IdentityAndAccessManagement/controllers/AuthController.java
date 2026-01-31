package com.example.IdentityAndAccessManagement.controllers;

import com.example.IdentityAndAccessManagement.entities.User;
import com.example.IdentityAndAccessManagement.service.userDetailsService;
import com.example.IdentityAndAccessManagement.service.userService;
import com.example.IdentityAndAccessManagement.DTO.UserDTO;
import com.example.IdentityAndAccessManagement.DTO.validateResponse;
import com.example.IdentityAndAccessManagement.repositories.UserRepository;
import com.example.IdentityAndAccessManagement.repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.example.IdentityAndAccessManagement.security.JwtUtil; 
import com.example.IdentityAndAccessManagement.entities.AuthResponse;


@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private userService userService;
    
    @Autowired
    private ClientRepository clientRepo;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserDTO request) {
        if (clientRepo.findByClientId(request.getClientId()).isPresent()||clientRepo.findByClientSecret(request.getKey()).isPresent()){
        try {
            User user = userService.registerNewUser(request);
            return ResponseEntity.ok("User registered successfully with ID: " + user.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }} else {
            return ResponseEntity.ok("somthing went wrong");
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO request) {
        
        if (clientRepo.findByClientId(request.getClientId()).isPresent()||clientRepo.findByClientSecret(request.getKey()).isPresent()){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword())
        );

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
        } else {
            return ResponseEntity.ok("somthing went wrong");
        }
    }
    
    @PostMapping("/validateToken")
    public ResponseEntity<?> validate (@RequestBody validateResponse request){
        
        String token = request.getToken();
        
        if (jwtUtil.isTokenValid(token)) {
            return ResponseEntity.ok(new validateResponse(true));
        } else {
            return ResponseEntity.ok(new validateResponse(false));
        }
    }
}