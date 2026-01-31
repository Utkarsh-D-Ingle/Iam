package com.example.IdentityAndAccessManagement.DTO;

public class validateResponse{
    
    private String token;
    
    private boolean isValid;
    
    public validateResponse(){}
    
    public validateResponse(boolean isValid){
        this.isValid = isValid;
    }
    
    public validateResponse(String token, boolean isValid){
        this.token = token;
        this.isValid = isValid;
    }
    
    public void setToken(String token){
        this.token = token;
    }
    
    public String getToken(){
        return token;
    }
    
    public void setValidity(boolean isValid){
        this.isValid = isValid;
    }
    
    public boolean getValidity(){
        return isValid;
    }
}