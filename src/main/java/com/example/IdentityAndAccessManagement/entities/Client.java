package com.example.IdentityAndAccessManagement.entities;

import jakarta.persistence.*;

@Entity
public class Client {

    @Id
    private String clientId;

    private String clientSecret;

    private String appName;

    private boolean active;
    
    public Client(String clientId, String clientSecret, String appName){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.appName = appName;
    }
    
    public Client(){}
    
    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getAppName() {
        return appName;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}