package com.example.demo;
import java.util.List;

public interface UserServiceInterface {
    User creatUser(User user);
    User updatUser(User user,Integer id);
    void deletUser(Integer id);
    List<User> getallUsers();
    User getUserByID(Integer id);
    // User loginUser(User user);
}


