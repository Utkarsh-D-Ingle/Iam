package com.example.IdentityAndAccessManagement.controllers;

import com.example.IdentityAndAccessManagement.entities.Client;
import com.example.IdentityAndAccessManagement.service.clientService;
import com.example.IdentityAndAccessManagement.DTO.clientResponse;
import com.example.IdentityAndAccessManagement.DTO.clientDTO;
import com.example.IdentityAndAccessManagement.repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/client")
public class ClientRegistrationController {
    
    @Autowired
    private clientService clientService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody clientDTO request) {
        try {
            Client newClient = clientService.registerNewClient(request);
            clientResponse response = new clientResponse();
            response.setId(newClient.getClientId());
            response.setKey(newClient.getClientSecret());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}