package com.example.IdentityAndAccessManagement.repositories;

import com.example.IdentityAndAccessManagement.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // Custom query to find a user by their username
    Optional<Client> findByClientId(String clientId);
    
    Optional<Client> findByAppName(String AppName);
    
    Optional<Client> findByClientSecret(String clientSecret);
}
