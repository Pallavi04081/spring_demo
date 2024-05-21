package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      
      private  Integer id;

      @Column(nullable = false)
      private  String name;

      @Column(nullable = false)
      private  String username;

    

    @Column(nullable = false,unique = true)
      private String password;

      @Column(nullable = false,unique = true)
      private  Integer  mobileNumber;
      
      @Column(nullable = true)
      private String accessToken;
      
      @Column(nullable = true)
      private String refreshToken;
      
      @Column(nullable = true)
      private String email;

    public User() {
    }


    public User(Integer id, String name, String username, String password, Integer mobileNumber, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public String getAccessToken() {
        return accessToken;
    }


    public String getRefreshToken() {
        return refreshToken;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        // Hash the password using bcrypt
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.password = hashedPassword;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    } 
    
    public boolean checkPassword(String plainTextPassword) {
        // Check if the provided plain text password matches the hashed password
        return BCrypt.checkpw(plainTextPassword, this.password);
    }
    
}


