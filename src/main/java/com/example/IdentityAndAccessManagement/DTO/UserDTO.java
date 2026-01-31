package com.example.IdentityAndAccessManagement.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    
    @NotBlank(message = "client id is required")
    private String clientId;
    
    @NotBlank(message = "Secret key is required")
    private String SecretKey;
    
    @NotBlank(message = "Username is required")
    private String username;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
    
    public String getClientId(){ return clientId;}
    public void setClientId(String clientId){ this.clientId = clientId;}
    public String getKey(){ return SecretKey;}
    public void setKey(String SecretKey){ this.SecretKey = SecretKey;}
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}