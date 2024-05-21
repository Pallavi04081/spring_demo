package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User creatUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updatUser(User user, Integer id) {
        User userObj = userRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("User not found"));

        userObj.setUsername(user.getUsername());
        userObj.setPassword(user.getPassword());

        return userRepository.save(userObj);
    }

    @Override
    public void deletUser(Integer id) {
        userRepository.deleteById(id);
    }


    // @Override
    // public User loginUser(User user){
    // Optional<User> existingUserOptional = userRepository.findOneByUsername(user.getUsername());
    // User existingUser = existingUserOptional.orElseThrow(() -> new ResourceAccessException("User not found"));
    // boolean isPasswordCorrect = user.checkPassword(user.getPassword());
    // if (isPasswordCorrect) {
    //     // Generate JWT access token
    //     String accessToken = generateAccessToken(existingUser.getUsername());
    //     existingUser.setAccessToken(accessToken);
    //     userRepository.save(existingUser);
    //     res
    // } else {
    //     throw new IllegalArgumentException("Incorrect password");
    // }
    // }
 
    // private String generateAccessToken(String username) {
    // long expirationTimeMillis = System.currentTimeMillis() + 3600000; // 1 hour
    // return Jwts.builder()
    //         .setSubject(username)
    //         .setExpiration(new Date(expirationTimeMillis))
    //         .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // Change yourSecretKey to your actual secret key
    //         .compact();
    // }



    @Override
    public User getUserByID(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("User not found"));
    }

    @Override
    public List<User> getallUsers() {
        return userRepository.findAll();
    }
}
