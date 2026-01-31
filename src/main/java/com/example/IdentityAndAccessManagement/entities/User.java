package com.example.IdentityAndAccessManagement.entities;

import jakarta.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "app_users")
public class User implements UserDetails { // 1. Add implements
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    private String passwordhash;

    public User() {}

    public User(String username, String passwordhash) {
        this.username = username;
        this.passwordhash = passwordhash;
    }

    // --- UserDetails Implementation ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Giving every user a default role. 
        // You can later store roles in the DB if needed.
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.passwordhash; // Map your field to Spring's requirement
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Set to true for simple use cases
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // --- Standard Getters and Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswordhash() { return passwordhash; }
    public void setPasswordhash(String passwordhash) { this.passwordhash = passwordhash; }
}
