package com.example.IdentityAndAccessManagement.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class clientDTO {
    
    @NotBlank(message = "App name is required")
    private String AppName;
    
    @NotBlank(message = "Create your secret key")
    @Size(min = 8, message = "key must be at least 8 characters")
    private String Secret;
    
    public String getAppName() { return AppName; }
    public void setAppName(String AppName) { this.AppName = AppName; }
    public String getSecret() { return Secret; }
    public void setPassword(String Secret) { this.Secret = Secret; }
}