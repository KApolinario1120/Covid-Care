package com.tegdihackathon.covidcare.dao;

import com.tegdihackathon.covidcare.model.User;
import java.util.List;

public interface UserDao {

    //Create a user
    boolean createUser(String username, String password);

    //Retrieve a list of all users
    List<User> getAllUsers();

    //Get a user by id
    User getUserById(int userId);

    //get a user ID by username
    int findIdByUsername(String username);

    //Update a user
    User updateUser(User user, String username);

    //Delete a user
    User deleteUser(User user, String username);
}
