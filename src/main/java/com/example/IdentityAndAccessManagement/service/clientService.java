package com.example.IdentityAndAccessManagement.service;

import com.example.IdentityAndAccessManagement.repositories.ClientRepository;
import com.example.IdentityAndAccessManagement.entities.Client;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.IdentityAndAccessManagement.security.securityConfig;
import com.example.IdentityAndAccessManagement.DTO.clientDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class clientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public Client registerNewClient(clientDTO request) {
        // 1. Check if username is taken
        if (clientRepository.findByAppName(request.getAppName()).isPresent()) {
            throw new RuntimeException("App already registered or pick diffrent app name");
        }

        // 2. Create entity and ENCODE the password
        Client newClient = new Client();
        newClient.setAppName(request.getAppName());
        
        // This is the crucial part;
        String salt = "trxutfhyfhi7cbi8uf6th";
        String encodedSecretKey = passwordEncoder.encode(request.getSecret()+salt);
        String generatedClientId = passwordEncoder.encode(request.getAppName()+salt);
        newClient.setClientId(generatedClientId);
        newClient.setClientSecret(encodedSecretKey);

        // 3. Save to database
        return clientRepository.save(newClient);
    }
}
