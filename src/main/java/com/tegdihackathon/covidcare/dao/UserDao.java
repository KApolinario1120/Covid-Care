package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.User;
import java.util.List;

public interface UserDao {

    //Create a user
    User createUser(String userName, int userId, String password);

    //Retrieve a list of all users
    List<User> getAllUsers();

    //Get a user by id
    User getUserById(int userId);

    //get a user by username
    User getUserByUserName(String userName);

    //Update a user
    User updateUser(User user, String userName);

    //Delete a user
    User deleteUser(User user, String username);
}
