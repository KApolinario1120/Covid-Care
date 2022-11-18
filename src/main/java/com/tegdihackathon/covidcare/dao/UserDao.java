package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.User;
import java.util.List;

public interface UserDao {
    //Create
    User createUser(User user);

    //Retrieve
    List<User> getAllUsers();

    User getUserById(int userId);

    User getUserByUserName(String userName);

    boolean create(String userName, String password);

    //Update
    User updateUser(User user, String userName);

    //Delete
    User deleteUser(User user, String username);
}
