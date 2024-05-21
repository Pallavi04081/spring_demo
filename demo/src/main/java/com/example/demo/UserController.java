package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceInterface userServiceInterface;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userObj = userServiceInterface.creatUser(user);
        return new ResponseEntity<>(userObj, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        System.out.println(user);
        System.out.println(id);
        User userObj = userServiceInterface.updatUser(user, id);
        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userServiceInterface.getallUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User userObj = userServiceInterface.getUserByID(id);
        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
    userServiceInterface.deletUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // @GetMapping
    // public ResponseEntity<User> loginUser(@RequestBody User user){
    //    User userobj = userServiceInterface.loginUser(user);
    //    return new ResponseEntity<>(userobj,HttpStatus.OK);
    // }
}
