package com.example.IdentityAndAccessManagement.DTO;

public class clientResponse{
    
    private String clientId;
    
    private String SecretKey;
    
    public clientResponse(){}
    
    public clientResponse(String clientId, String SecretKey){
        this.clientId = clientId;
        this.SecretKey = SecretKey;
    }
    
    public String getId(){
        return clientId;
    }
    
    public String getKey(){
        return SecretKey;
    }
    
    public void setKey(String SecretKey){
        this.SecretKey = SecretKey;
    }
    
    public void setId(String clientId){
        this.clientId = clientId;
    }
}